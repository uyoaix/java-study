package com.study.yufei.design.pattern.compound;

/**
 * @author yufei.wang
 * @date 2020/12/08 13:54
 */
public class Quackologist implements Observer{
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked.");
    }
}
