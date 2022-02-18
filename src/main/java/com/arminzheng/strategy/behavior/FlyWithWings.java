package com.arminzheng.strategy.behavior;

import com.arminzheng.strategy.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
  public void fly() {
    System.out.println("I'm flying!!");
  }
}
