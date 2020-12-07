package com.study.yufei.design.pattern.adapter;

/**
 * @author yufei.wang
 * @date 2020/12/07 15:02
 */
public class MallardDuck implements Duck{
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
