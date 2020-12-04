package com.study.yufei.design.pattern.singleton;

/**
 * 普通单例模式：饱汉式
 *
 * @author yufei.wang
 * @date 2020/12/04 18:02
 */
public class Singleton3 {
    private static Singleton3 instance = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return instance;
    }
}
