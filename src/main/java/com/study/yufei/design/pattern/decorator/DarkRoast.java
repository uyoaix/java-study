package com.study.yufei.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * 深焙咖啡
 *
 * @author yufei.wang
 * @date 2020/12/01 19:54
 */
public class DarkRoast extends Beverage {

    public DarkRoast(){
        description = "DarkRoast";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("0.99");
    }
}
