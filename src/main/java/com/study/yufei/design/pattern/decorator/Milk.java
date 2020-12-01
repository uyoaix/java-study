package com.study.yufei.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * 调料：牛奶
 *
 * @author yufei.wang
 * @date 2020/12/01 21:38
 */
public class Milk extends CondimentDecorator{

    private Beverage beverage;

    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("0.10").add(beverage.cost());
    }
}
