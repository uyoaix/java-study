package com.study.yufei.design.pattern.factory;

/**
 * @author yufei.wang
 * @date 2020/12/04 10:00
 */
public class Pizza {

    public void prepare(){
        System.out.println("prepare");
    }

    public void bake(){
        System.out.println("bake");
    }

    public void cut(){
        System.out.println("cut");
    }

    public void box(){
        System.out.println("box");
    }

}
