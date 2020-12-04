package com.study.yufei.design.pattern.singleton;

/**
 * 强同步单例模式：synchronized 强同步，会降低性能
 *
 *
 * @author yufei.wang
 * @date 2020/12/04 17:57
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {
    }

    public synchronized static Singleton2 getInstance() {
        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}
