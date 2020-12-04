package com.study.yufei.design.pattern.factory.abstracts;

import com.study.yufei.design.pattern.factory.abstracts.ingredients.*;

/**
 * 抽象工厂 披萨类
 *
 * @author yufei.wang
 * @date 2020/12/04 16:41
 */
public abstract class AbstractPizza {

    /**
     * 披萨名称
     */
    String name;

    /**
     * 面团
     */
    Dough dough;

    /**
     * 酱料
     */
    Sauce sauce;

    /**
     * 蔬菜
     */
    Veggies[] veggies;

    /**
     * 芝士
     */
    Cheese cheese;

    /**
     * 意大利烤肠
     */
    Pepperoni pepperoni;

    /**
     * 蛤蜊
     */
    Clams clams;

    abstract void prepare();

    void bake(){
        System.out.println("bake ");
    }

    void cut(){
        System.out.println("cut");
    }

    void box(){
        System.out.println("box");
    }

}
