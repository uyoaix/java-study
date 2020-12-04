package com.study.yufei.design.pattern.factory;

import com.study.yufei.design.pattern.factory.method.AbstractPizza;
import com.study.yufei.design.pattern.factory.method.ChicagoPizzaStore;
import com.study.yufei.design.pattern.factory.method.NYPizzaStore;
import com.study.yufei.design.pattern.factory.method.PizzaStore;

/**
 * @author yufei.wang
 * @date 2020/12/04 11:45
 */
public class PizzaTest {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        AbstractPizza pizza = nyStore.createPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        AbstractPizza pizza1 = chicagoStore.createPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
