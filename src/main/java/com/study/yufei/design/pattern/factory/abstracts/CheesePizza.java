package com.study.yufei.design.pattern.factory.abstracts;

/**
 * @author yufei.wang
 * @date 2020/12/04 16:55
 */
public class CheesePizza extends AbstractPizza{

    private final PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory){
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("prepare " + name);
        pizzaIngredientFactory.createDough();
        pizzaIngredientFactory.createSauce();
        pizzaIngredientFactory.createCheese();
    }
}
