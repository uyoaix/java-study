package com.study.yufei.design.pattern.singleton;

/**
 * 普通单例：饿汉式，延迟加载
 *
 * @author yufei.wang
 * @date 2020/12/04 17:45
 */
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (null == instance) {
            instance = new Singleton1();
        }
        return instance;
    }
}
