package com.arminzheng.factory;

/**
 * PizzaStore
 *
 * @author zy
 * @version 2022/1/21
 */
public abstract class PizzaStore {

  public Pizza orderPizza(String type) {
    Pizza pizza;
    pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }

  protected abstract Pizza createPizza(String type);
}
