package com.study.yufei.design.pattern.decorator;

/**
 * 调料装饰器
 *
 * @author yufei.wang
 * @date 2020/12/01 19:59
 */
public abstract class CondimentDecorator extends Beverage{

    @Override
    public abstract String getDescription();

}
