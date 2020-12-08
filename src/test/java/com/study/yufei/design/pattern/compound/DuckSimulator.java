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
        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        simulator.simulator(duckFactory);
    }

    void simulator(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable readheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.crateDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();

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
