package com.study.yufei.design.pattern.factory.factory;

/**
 * 芝加哥风味披萨店
 *
 * @author yufei.wang
 * @date 2020/12/04 10:45
 */
public class ChicagoStylePizzaStore extends PizzaStore {

    @Override
    public AbstractPizza createPizza(String type) {
        AbstractPizza pizza = null;

        if ("cheese".equals(type)) {
            pizza = new ChicagoStyleCheesePizza();
        } else if ("clam".equals(type)) {
            pizza = new ChicagoStyleCheesePizza();
        }

        return pizza;
    }
}
