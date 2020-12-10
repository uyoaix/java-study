package com.study.yufei.design.pattern.compound;

/**
 * 鹅适配器
 *
 * @author yufei.wang
 * @date 2020/12/08 11:32
 */
public class GooseAdapter implements Quackable {

    private Goose goose;

    public GooseAdapter(Goose goose){
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
