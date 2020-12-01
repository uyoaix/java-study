package com.study.yufei.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * 浓缩咖啡
 *
 * @author yufei.wang
 * @date 2020/12/01 19:55
 */
public class Espresso extends Beverage{

    public Espresso(){
        description = "Espresso";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("1.99");
    }
}
