package com.study.yufei.design.pattern.factory.method;

/**
 * 纽约披萨店
 *
 * @author yufei.wang
 * @date 2020/12/04 10:45
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    public AbstractPizza createPizza(String type) {
        AbstractPizza pizza = null;

        if ("cheese".equals(type)) {
            pizza = new NYStyleCheesePizza();
        } else if ("clam".equals(type)) {
            pizza = new NYStyleClamPizza();
        }
        return pizza;
    }
}
