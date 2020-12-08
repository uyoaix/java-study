package com.study.yufei.design.pattern.compound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yufei.wang
 * @date 2020/12/08 13:49
 */
public class Observable implements QuackObservable{

    List<Observer> observers = new ArrayList<>();

    private QuackObservable duck;

    public Observable(QuackObservable duck){
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()){
            Observer observer = iterator.next();
            observer.update(duck);
        }
    }
}
