package com.arminzheng.strategy;

import com.arminzheng.strategy.behavior.FlyNoWay;
import com.arminzheng.strategy.behavior.MuteQuack;

/**
 * @author armin
 * @version 2021/12/9
 */
public class StrategyTestDrive {

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
