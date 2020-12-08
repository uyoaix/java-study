package com.study.yufei.design.pattern.compound;

/**
 * 抽象工厂模式：创建不同类型鸭子的产品家族
 *
 * @author yufei.wang
 * @date 2020/12/08 11:44
 */
public abstract class AbstractDuckFactory {

    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedheadDuck();

    public abstract Quackable crateDuckCall();

    public abstract Quackable createRubberDuck();

}
