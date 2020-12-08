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
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable readheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());

        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\nDuck simulator: ");
        simulate(mallardDuck);
        simulate(readheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");

    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
