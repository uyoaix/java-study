package com.study.yufei.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 支持互斥性
 * 支持锁超时
 * 支持阻塞和非阻塞
 * 支持可重入性
 * 支持高可用
 *
 * CAP理论：CP 或 AP
 * 1）C：Consistency 一致性
 * 2）A: Availability 可用性
 * 3）P: Partition tolerance 分区容错性
 *
 * 1. 如果其他地方没有调用tryLock方法，而是直接调用了releaseLock方法，传的key是一样的，那就会出现问题：把别人的锁释放掉了
 * 2. 锁重入：还有一种场景就是在提交订单的接口方法中，调用了服务A，服务A调用了服务B，而服务B的方法中存在对同一个商品的加锁和解锁操作。
 * 所以，服务B成功设置锁标志位后，提交订单的接口方法继续执行时，也不能成功设置锁标志位了。
 * 也就是说，目前实现的分布式锁没有可重入性。
 * 3. 计数器：假设我们提交订单的方法中，首先使用RedisLock接口对代码块添加了分布式锁，在加锁后的代码中调用了服务A，而服务A中也存在调用RedisLock接口的加锁和解锁操作。而多次调用RedisLock接口的加锁操作时，只要之前的锁没有失效，则会直接返回true，表示成功获取锁。
 * 也就是说，无论调用加锁操作多少次，最终只会成功加锁一次。
 * 而执行完服务A中的逻辑后，在服务A中调用RedisLock接口的解锁方法，
 * 此时，会将当前线程所有的加锁操作获得的锁全部释放掉。
 * 4. 阻塞与非阻塞：在提交订单的方法中，当获取Redis分布式锁失败时，我们直接返回了failure来表示当前请求下单的操作失败了。
 * 试想，在高并发环境下，一旦某个请求获得了分布式锁，那么，在这个请求释放锁之前，其他的请求调用下单方法时，都会返回下单失败的信息。
 * 在真实场景中，这是非常不友好的。我们可以将后续的请求进行阻塞，直到当前请求释放锁后，再唤醒阻塞的请求获得分布式锁来执行方法。
 *
 * @author yufei.wang
 * @date 2021/03/15 17:13
 */
@Service
public class DistributedLockImpl implements DistributedLock {

    private final StringRedisTemplate stringRedisTemplate;

    public DistributedLockImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<>();

    @Override
    public Boolean tryLock(String key, long timeout, TimeUnit unit) {
        boolean isLocked = false;
        // 当前线程已获取锁，再次调用直接返回true，锁可重入
        if (threadLocal.get() == null) {
            String uuid = UUID.randomUUID().toString();
            threadLocal.set(uuid);
            isLocked = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid, timeout, unit);
            if(!isLocked){
                // 获取锁失败，增加自旋，进行阻塞，知道获取锁成功
                // 缺点：锁自旋会耗用cpu资源，且即时响应接口等待时间过长也不合适
                do {
                    isLocked = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid, timeout, unit);
                } while (!isLocked);
            }
        } else {
            isLocked = true;
        }
        if(isLocked){
            // 加锁成功，计数器+1
            Integer count = threadLocalCounter.get() == null ? 0 : threadLocalCounter.get();
            threadLocalCounter.set(count++);
        }

        return isLocked;
    }

    @Override
    public void releaseLock(String key) {
        //当前线程中绑定的uuid与Redis中的uuid相同时，再执行删除锁的操作
        if (threadLocal.get().equals(stringRedisTemplate.opsForValue().get(key))) {
            Integer count = threadLocalCounter.get();
            // 线程计数器不存在或是为0，可以释放锁
            if(null == count || --count <= 0){
                stringRedisTemplate.delete(key);
            }
        }
    }
}
