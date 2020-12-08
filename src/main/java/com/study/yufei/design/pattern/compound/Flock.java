package com.study.yufei.design.pattern.compound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yufei.wang
 * @date 2020/12/08 11:54
 */
public class Flock implements Quackable {

    List<Quackable> quackers = new ArrayList<>();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.quack();
        }

    }
}
