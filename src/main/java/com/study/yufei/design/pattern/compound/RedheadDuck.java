package com.study.yufei.design.pattern.compound;

/**
 * @author yufei.wang
 * @date 2020/12/08 11:23
 */
public class RedheadDuck implements Quackable{

    private Observable observable;

    public RedheadDuck(){
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("quack");
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
