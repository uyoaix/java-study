package com.study.yufei.design.pattern.template;

/**
 * @author yufei.wang
 * @date 2020/12/07 15:56
 */
public abstract class CaffeineBeverage {

    /**
     * 模版方法
     */
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantCondiments()) {
            addCondiments();
        }
    }

    public abstract void brew();

    public abstract void addCondiments();

    void boilWater() {
        System.out.println("boil water");
    }

    void pourInCup() {
        System.out.println("pour in cup");
    }

    /**
     * 钩子
     *
     * @return boolean
     */
    public boolean customerWantCondiments() {
        return true;
    }

}
