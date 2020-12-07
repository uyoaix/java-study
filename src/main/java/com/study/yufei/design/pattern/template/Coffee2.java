package com.study.yufei.design.pattern.template;

/**
 * @author yufei.wang
 * @date 2020/12/07 16:18
 */
public class Coffee2 extends CaffeineBeverage{
    @Override
    public void brew() {
        System.out.println("brew coffee through filter");
    }

    @Override
    public void addCondiments() {
        System.out.println("add sugar and milk");
    }
}
