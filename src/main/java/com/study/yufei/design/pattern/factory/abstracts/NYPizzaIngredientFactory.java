package com.study.yufei.design.pattern.factory.abstracts;

import com.study.yufei.design.pattern.factory.abstracts.ingredients.*;

/**
 * @author yufei.wang
 * @date 2020/12/04 16:32
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory{

    @Override
    public Dough createDough() {
        return null;
    }

    @Override
    public Sauce createSauce() {
        return null;
    }

    @Override
    public Cheese createCheese() {
        return null;
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[0];
    }

    @Override
    public Pepperoni createPepperoni() {
        return null;
    }

    @Override
    public Clams createClam() {
        return null;
    }
}
