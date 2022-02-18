package com.arminzheng.strategy;

import com.arminzheng.strategy.behavior.FlyWithWings;
import com.arminzheng.strategy.behavior.Quack;

/**
 * @author armin
 * @version 2021/12/9
 */
public class ModelDuck extends Duck {

  public ModelDuck() {
    flyBehavior = new FlyWithWings();
    quackBehavior = new Quack();
  }

  @Override
  public void display() {
    System.out.println("I'm Model Duck!");
  }
}
