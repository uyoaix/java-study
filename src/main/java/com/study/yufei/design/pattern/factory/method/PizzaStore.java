package com.study.yufei.design.pattern.factory.method;

/**
 * 工厂方法模式：通过让子类决定该创建的对象是什么，来到达将对象创建的过程封装的目的
 * 把披萨店定义为抽象类，创建pizza的方法为抽象工厂方法，
 * 每个地区的披萨店继承自这里，创建披萨由子类决定
 *
 * @author yufei.wang
 * @date 2020/12/04 10:42
 */
public abstract class PizzaStore {

    /**
     * 定义为final类型，不允许子类修改
     *
     * @param type
     */
    public final void orderPizza(String type) {

        AbstractPizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    public abstract AbstractPizza createPizza(String type);
}
