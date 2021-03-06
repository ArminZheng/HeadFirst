package com.arminzheng.factory.simple;

import com.arminzheng.factory.simple.pizza.CheesePizza;
import com.arminzheng.factory.simple.pizza.ClamPizza;
import com.arminzheng.factory.simple.pizza.PepperoniPizza;
import com.arminzheng.factory.simple.pizza.VeggiePizza;

public class SimplePizzaFactory {

  /**
   * 简单工厂不是一个设计模式，是一种编程习惯
   *
   * @param type
   * @return
   */
  public Pizza createPizza(String type) {
    Pizza pizza = null;

    if (type.equals("cheese")) {
      pizza = new CheesePizza();
    } else if (type.equals("pepperoni")) {
      pizza = new PepperoniPizza();
    } else if (type.equals("clam")) {
      pizza = new ClamPizza();
    } else if (type.equals("veggie")) {
      pizza = new VeggiePizza();
    }
    return pizza;
  }
}
