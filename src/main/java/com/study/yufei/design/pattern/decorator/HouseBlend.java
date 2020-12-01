package com.study.yufei.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * @author yufei.wang
 * @date 2020/12/01 19:57
 */
public class HouseBlend extends Beverage{

    public HouseBlend(){
        description = "HouseBlend";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("0.89");
    }
}
