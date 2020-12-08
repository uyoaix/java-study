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

        System.out.println("\nDuck simulator: With Composite - Flocks");

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(gooseDuck);
        flockOfDucks.add(readheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);

        Flock flockOfMallards = new Flock();
        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        flockOfDucks.add(flockOfMallards);
        System.out.println("\n Duck Simulator:Whole Flock Simulation: ");
        simulate(flockOfDucks);

        System.out.println("\n DUck Simulator: Mallard Flock Simulator: ");
        simulate(flockOfMallards);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");

    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
