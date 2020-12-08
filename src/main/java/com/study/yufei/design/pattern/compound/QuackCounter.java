package com.study.yufei.design.pattern.compound;

/**
 * @author yufei.wang
 * @date 2020/12/08 11:38
 */
public class QuackCounter implements Quackable {

    private Quackable duck;

    static int numberOfQuacks;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }
}
