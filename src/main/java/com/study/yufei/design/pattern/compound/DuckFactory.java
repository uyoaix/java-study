package com.study.yufei.design.pattern.compound;

/**
 * @author yufei.wang
 * @date 2020/12/08 11:47
 */
public class DuckFactory extends AbstractDuckFactory{

    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable crateDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }
}
