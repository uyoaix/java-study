package com.study.yufei.design.pattern.factory.factory;

/**
 * @author yufei.wang
 * @date 2020/12/04 10:56
 */
public class ChicagoStyleCheesePizza extends AbstractPizza {

    public ChicagoStyleCheesePizza(){
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded MOzzarella Cheese");
    }
}
