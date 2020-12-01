package com.study.yufei.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * 调料：奶泡
 *
 * @author yufei.wang
 * @date 2020/12/01 21:32
 */
public class Whip extends CondimentDecorator {

    private Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("0.10").add(beverage.cost());
    }
}
