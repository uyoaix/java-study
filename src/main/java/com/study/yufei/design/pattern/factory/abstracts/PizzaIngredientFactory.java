package com.study.yufei.design.pattern.factory.abstracts;

import com.study.yufei.design.pattern.factory.abstracts.ingredients.*;

/**
 * 披萨原料工厂
 *
 * @author yufei.wang
 * @date 2020/12/04 16:17
 */
public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClam();

}
