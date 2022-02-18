package com.arminzheng.factory.method;

public abstract class PizzaStore {

  /**
   * 工厂方法模板（factory method pattern） abstract Product factoryMethod(String type);
   *
   * @param item 类型
   * @return 生产对象
   */
  protected abstract Pizza createPizza(String item);

  public Pizza orderPizza(String type) {
    Pizza pizza = createPizza(type);
    System.out.println("--- Making a " + pizza.getName() + " ---");
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
  }
}
