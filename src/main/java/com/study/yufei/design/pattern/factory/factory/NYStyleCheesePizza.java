package com.study.yufei.design.pattern.factory.factory;

/**
 * @author yufei.wang
 * @date 2020/12/04 10:55
 */
public class NYStyleCheesePizza extends AbstractPizza {

    public NYStyleCheesePizza(){
        name = "New York Sauce and Cheese style Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }

}
