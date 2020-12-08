package com.study.yufei.design.pattern.compound;

/**
 * 鸭鸣器
 *
 * @author yufei.wang
 * @date 2020/12/08 11:24
 */
public class DuckCall implements Quackable {
    @Override
    public void quack() {
        System.out.println("Kwak");
    }
}
