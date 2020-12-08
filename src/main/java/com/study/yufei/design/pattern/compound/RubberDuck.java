package com.study.yufei.design.pattern.compound;

/**
 * 橡皮鸭
 *
 * @author yufei.wang
 * @date 2020/12/08 11:25
 */
public class RubberDuck implements Quackable {

    private Observable observable;

    public RubberDuck(){
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("squeak");
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
