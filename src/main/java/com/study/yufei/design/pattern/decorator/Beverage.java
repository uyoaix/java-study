package com.study.yufei.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * 饮料类
 *
 * @author yufei.wang
 * @date 2020/11/30 20:28
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract BigDecimal cost();
}
