package com.study.yufei.design.pattern.template;

/**
 * @author yufei.wang
 * @date 2020/12/07 15:56
 */
public class Coffee {

    void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    public void boilWater() {
        System.out.println("boil water");
    }

    public void brewCoffeeGrinds(){
        System.out.println("Dripping coffee through filter");
    }

    public void pourInCup(){
        System.out.println("pour in cup");
    }

    public void addSugarAndMilk(){
        System.out.println("add sugar and milk");
    }

}
