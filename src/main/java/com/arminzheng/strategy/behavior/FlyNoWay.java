package com.arminzheng.strategy.behavior;

import com.arminzheng.strategy.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
  public void fly() {
    System.out.println("I can't fly");
  }
}
