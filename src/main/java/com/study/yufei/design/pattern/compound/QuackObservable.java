package com.study.yufei.design.pattern.compound;


/**
 * @author yufei.wang
 * @date 2020/12/08 12:07
 */
public interface QuackObservable {

    void registerObserver(Observer observer);

    void notifyObservers();
}
