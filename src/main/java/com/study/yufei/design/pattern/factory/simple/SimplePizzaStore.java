package com.study.yufei.design.pattern.factory.simple;

import com.study.yufei.design.pattern.factory.Pizza;

/**
 * @author yufei.wang
 * @date 2020/12/04 09:59
 */
public class SimplePizzaStore {

    private SimplePizzaFactory simplePizzaFactory;

    public SimplePizzaStore(SimplePizzaFactory simplePizzaFactory){
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(String type){

        Pizza pizza = simplePizzaFactory.createPizza("cheese");
        assert pizza != null;

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;


    }
}
