package com.study.yufei.design.pattern.factory;

/**
 * 披萨类
 *
 * @author yufei.wang
 * @date 2020/12/04 10:00
 */
public interface Pizza {

    /**
     * 准备
     */
    default void prepare(){
        System.out.println("prepare");
    }

    /**
     * 烘焙
     */
    default void bake(){
        System.out.println("bake");
    }


    /**
     * 切片
     */
    default void cut(){
        System.out.println("cut");
    }

    /**
     * 装盒
     */
    default void box(){
        System.out.println("box");
    }

}
