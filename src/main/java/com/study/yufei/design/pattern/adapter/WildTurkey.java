package com.study.yufei.design.pattern.adapter;

/**
 * @author yufei.wang
 * @date 2020/12/07 15:03
 */
public class WildTurkey implements Turkey{
    @Override
    public void gobble() {
        System.out.println("gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
