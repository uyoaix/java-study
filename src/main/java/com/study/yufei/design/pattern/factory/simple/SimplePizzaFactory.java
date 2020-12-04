package com.study.yufei.design.pattern.factory.simple;

import com.study.yufei.design.pattern.factory.Pizza;

/**
 * 简单披萨工厂
 *
 * @author yufei.wang
 * @date 2020/12/04 10:20
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if("cheese".equals(type)){
            pizza = new CheesePizza();
        } else if("greek".equals(type)){
            pizza = new GreekPizza();
        } else if("pepperoni".equals(type)){
            pizza = new PepperoniPizza();
        }

        return pizza;
    }
}
