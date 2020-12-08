package com.study.yufei.design.pattern.compound;

/**
 * 绿头鸭
 *
 * @author yufei.wang
 * @date 2020/12/08 11:22
 */
public class MallardDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("quack");
    }
}
