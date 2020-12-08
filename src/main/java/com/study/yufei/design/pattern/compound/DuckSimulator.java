package com.study.yufei.design.pattern.compound;

/**
 * 模拟器
 *
 * @author yufei.wang
 * @date 2020/12/08 11:26
 */
public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulator();
    }

    void simulator() {
        Quackable mallardDuck = new MallardDuck();
        Quackable readheadDuck = new RedheadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();

        System.out.println("\nDuck simulator");
        simulate(mallardDuck);
        simulate(readheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
