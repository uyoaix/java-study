package com.study.yufei.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * 调料：豆浆
 *
 * @author yufei.wang
 * @date 2020/12/01 21:34
 */
public class Soy extends CondimentDecorator {

    private Beverage beverage;

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("0.15").add(beverage.cost());
    }
}
