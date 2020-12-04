package com.study.yufei.design.pattern.factory.factory;

import com.study.yufei.design.pattern.factory.Pizza;

/**
 * 芝加哥风味披萨店
 *
 * @author yufei.wang
 * @date 2020/12/04 10:45
 */
public class ChicagoStylePizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;

        if ("cheese".equals(type)) {
            pizza = new ChicagoStyleCheesePizza();
        } else if ("clam".equals(type)) {
            pizza = new ChicagoStyleCheesePizza();
        }

        return pizza;
    }
}
