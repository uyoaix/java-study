package com.study.yufei.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * 调料：摩卡
 *
 * @author yufei.wang
 * @date 2020/12/01 21:27
 */
public class Mocha extends CondimentDecorator {

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("0.20").add(beverage.cost());
    }
}
