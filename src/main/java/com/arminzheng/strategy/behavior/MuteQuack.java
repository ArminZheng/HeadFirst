package com.arminzheng.strategy.behavior;

import com.arminzheng.strategy.QuackBehavior;

public class MuteQuack implements QuackBehavior {
  public void quack() {
    System.out.println("<< Silence >>");
  }
}
