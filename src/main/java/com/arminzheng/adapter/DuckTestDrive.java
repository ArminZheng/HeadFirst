package com.arminzheng.adapter;

import com.arminzheng.strategy.Duck;
import com.arminzheng.strategy.ModelDuck;

/**
 * 适配器模式 = 继承 + 组合
 *
 * <p>简单来说，继承目标，组合现有类（使用构造器）
 */
public class DuckTestDrive {
    public static void main(String[] args) {
        WildTurkey wildTurkey = new WildTurkey();
        System.out.println("test Turkey says...");
        wildTurkey.gobble();
        wildTurkey.fly();

        System.out.println(">>>>>>>>>\ntest TurkeyAdapter says...");
        Duck turkey = new TurkeyAdapter(wildTurkey);
        testDuck(turkey);

        System.out.println(">>>>>>>>>\ntest ModelDuck says...");
        ModelDuck modelDuck = new ModelDuck();
        testDuck(modelDuck);
    }

    static void testDuck(Duck duck) {
        duck.performQuack();
        duck.performFly();
    }
}
