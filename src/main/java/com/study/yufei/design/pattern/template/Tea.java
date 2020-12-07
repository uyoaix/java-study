package com.study.yufei.design.pattern.template;

/**
 * @author yufei.wang
 * @date 2020/12/07 16:00
 */
public class Tea {

    void prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    public void boilWater() {
        System.out.println("boil water");
    }

    public void steepTeaBag() {
        System.out.println("steep tea bag");
    }

    public void pourInCup() {
        System.out.println("pour in cup");
    }

    public void addLemon() {
        System.out.println("add lemon");
    }

}
