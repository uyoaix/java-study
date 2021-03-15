package com.study.yufei.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 1. 如果其他地方没有调用tryLock方法，而是直接调用了releaseLock方法，传的key是一样的，那就会出现问题：把别人的锁释放掉了
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
        String uuid = UUID.randomUUID().toString();
        threadLocal.set(uuid);
        return stringRedisTemplate.opsForValue().setIfAbsent(key, uuid, timeout, unit);
    }

    @Override
    public void releaseLock(String key) {
        //当前线程中绑定的uuid与Redis中的uuid相同时，再执行删除锁的操作
        if(threadLocal.get().equals(stringRedisTemplate.opsForValue().get(key))){
            stringRedisTemplate.delete(key);
        }
    }
}
