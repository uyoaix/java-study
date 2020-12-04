package com.study.yufei.design.pattern.factory.simple;

import com.study.yufei.design.pattern.factory.CheesePizza;
import com.study.yufei.design.pattern.factory.GreekPizza;
import com.study.yufei.design.pattern.factory.PepperoniPizza;
import com.study.yufei.design.pattern.factory.Pizza;

/**
 * @author yufei.wang
 * @date 2020/12/04 09:59
 */
public class PizzaStore {

    public Pizza orderPizza(String type){

        Pizza pizza = null;

        if("cheese".equals(type)){
            pizza = new CheesePizza();
        } else if("greek".equals(type)){
            pizza = new GreekPizza();
        } else if("pepperoni".equals(type)){
            pizza = new PepperoniPizza();
        }

        assert pizza != null;

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;


    }
}
