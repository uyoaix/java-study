package com.study.yufei.design.pattern.adapter;

/**
 * @author yufei.wang
 * @date 2020/12/07 15:01
 */
public class DuckTest {

    public static void main(String[] args) {

        MallardDuck mallardDuck = new MallardDuck();

        WildTurkey wildTurkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);

        System.out.println("The Turkey says...");
        wildTurkey.gobble();
        wildTurkey.fly();

        System.out.println("\nThe duck says");
        testDuck(mallardDuck);

        System.out.println("\nThe turkeyAdapter says...");
        testDuck(turkeyAdapter);
    }

    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
}
