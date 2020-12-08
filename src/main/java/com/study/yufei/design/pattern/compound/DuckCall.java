package com.study.yufei.design.pattern.compound;

/**
 * 鸭鸣器
 *
 * @author yufei.wang
 * @date 2020/12/08 11:24
 */
public class DuckCall implements Quackable {

    private Observable observable;

    public DuckCall(){
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Kwak");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
