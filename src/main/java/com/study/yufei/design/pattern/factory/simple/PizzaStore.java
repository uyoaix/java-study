package com.study.yufei.design.pattern.factory.simple;

import com.study.yufei.design.pattern.factory.Pizza;

/**
 * @author yufei.wang
 * @date 2020/12/04 09:59
 */
public class PizzaStore {

    public Pizza orderPizza(){

        Pizza pizza = new Pizza();

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;


    }
}
