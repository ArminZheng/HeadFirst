package com.arminzheng.factory.abstraction;

public abstract class PizzaStore {

  protected abstract Pizza createPizza(String item);

  public Pizza orderPizza(String type) {
    Pizza pizza = createPizza(type);
    System.out.println("--- Making a " + pizza.getName() + " ---");
    pizza.prepare();
    pizza.bake(); // 烘焙
    pizza.cut(); // 切块
    pizza.box(); // 装箱
    return pizza;
  }
}
