package com.arminzheng.strategy;

/**
 * @author armin
 * @version 2021/12/9
 */
public class Application {
    public static void main(String[] args) {
        ModelDuck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.performQuack();
        modelDuck.setFlyBehavior(new FlyNoWay());
        modelDuck.setQuackBehavior(new MuteQuack());
        modelDuck.performFly();
        modelDuck.performQuack();
    }
}
