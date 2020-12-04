package com.study.yufei.design.pattern.singleton;

/**
 * 单例模式：双重检查 加锁
 *
 * @author yufei.wang
 * @date 2020/12/04 18:05
 */
public class Singleton4 {

    /**
     * volatile 关键词确保，当instance变量被初始化后，多个线程正确处理instance变量
     */
    private volatile static Singleton4 instance;

    private Singleton4() {
    }

    /**
     * double check , locking
     * 双重检查，加锁 第一次创建时加锁，一旦创建后后面都直接返回
     *
     * @return Singleton4
     */
    public static Singleton4 getInstance() {
        if (null == instance) {
            synchronized (Singleton4.class) {
                if (null == instance) {
                    return new Singleton4();
                }
            }
        }
        return instance;
    }

}
