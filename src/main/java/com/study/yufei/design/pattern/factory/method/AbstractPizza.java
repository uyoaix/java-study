package com.study.yufei.design.pattern.factory.method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yufei.wang
 * @date 2020/12/04 11:23
 */
public abstract class AbstractPizza {

    String name;

    String dough;

    String sauce;

    List<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println("prepare " + name);
        System.out.println("Tossing dough ...");
        System.out.println("Add sauce ...");
        System.out.println("Add toppings: ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.print(toppings.get(i) + "  ");
        }
    }

    public void bake() {
        System.out.println("bake for 25 minutes");
    }

    public void cut() {
        System.out.println();
    }

    public void box() {

    }

    public String getName() {
        return name;
    }
}
