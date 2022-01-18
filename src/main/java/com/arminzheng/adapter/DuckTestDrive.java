package com.arminzheng.adapter;

import com.arminzheng.strategy.Duck;
import com.arminzheng.strategy.ModelDuck;

public class DuckTestDrive {
    public static void main(String[] args) {
        ModelDuck modelDuck = new ModelDuck();

        WildTurkey wildTurkey = new WildTurkey();
        Duck turkey = new TurkeyAdapter(wildTurkey);
        System.out.println("test Turkey says...");
        wildTurkey.gobble();
        wildTurkey.fly();
        System.out.println(">>>>>>>>>\ntest TurkeyAdapter says...");
        testDuck(turkey);
        System.out.println(">>>>>>>>>\ntest Duck says...");
        testDuck(modelDuck);
    }

    static void testDuck(Duck duck) {
        duck.performQuack();
        duck.performFly();
    }
}
