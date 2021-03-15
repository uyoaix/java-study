package com.study.yufei.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 1. 如果其他地方没有调用tryLock方法，而是直接调用了releaseLock方法，传的key是一样的，那就会出现问题：把别人的锁释放掉了
 * 2. 还有一种场景就是在提交订单的接口方法中，调用了服务A，服务A调用了服务B，而服务B的方法中存在对同一个商品的加锁和解锁操作。
 * 所以，服务B成功设置锁标志位后，提交订单的接口方法继续执行时，也不能成功设置锁标志位了。
 * 也就是说，目前实现的分布式锁没有可重入性。
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

    @Override
    public Boolean tryLock(String key, long timeout, TimeUnit unit) {
        Boolean isLocked = false;
        // 当前线程已获取锁，再次调用直接返回true，锁可重入
        if (threadLocal.get() == null) {
            String uuid = UUID.randomUUID().toString();
            threadLocal.set(uuid);
            isLocked = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid, timeout, unit);
        } else {
            isLocked = true;
        }

        return isLocked;
    }

    @Override
    public void releaseLock(String key) {
        //当前线程中绑定的uuid与Redis中的uuid相同时，再执行删除锁的操作
        if (threadLocal.get().equals(stringRedisTemplate.opsForValue().get(key))) {
            stringRedisTemplate.delete(key);
        }
    }
}
