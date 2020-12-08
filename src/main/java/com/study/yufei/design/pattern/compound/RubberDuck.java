package com.study.yufei.design.pattern.compound;

/**
 * 橡皮鸭
 *
 * @author yufei.wang
 * @date 2020/12/08 11:25
 */
public class RubberDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("squeak");
    }
}
