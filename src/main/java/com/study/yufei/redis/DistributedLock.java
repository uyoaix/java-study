package com.study.yufei.redis;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁
 *
 * @author yufei.wang
 * @date 2021/03/15 16:48
 */
public interface DistributedLock {


    Boolean tryLock(String key, long timeout, TimeUnit unit);

    void releaseLock(String key);

}
