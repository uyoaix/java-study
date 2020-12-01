package com.study.yufei.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * 低咖啡因咖啡
 *
 * @author yufei.wang
 * @date 2020/12/01 19:56
 */
public class Decaf extends Beverage{

    public Decaf(){
        description = "Decaf";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("1.05");
    }
}
