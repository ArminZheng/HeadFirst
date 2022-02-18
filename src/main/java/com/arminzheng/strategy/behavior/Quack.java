package com.arminzheng.strategy.behavior;

import com.arminzheng.strategy.QuackBehavior;

public class Quack implements QuackBehavior {
  public void quack() {
    System.out.println("Quack Quack");
  }
}
