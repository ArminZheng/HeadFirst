package com.arminzheng.factory.method.store;

import com.arminzheng.factory.method.*;
import com.arminzheng.factory.method.pizza.NYStyleCheesePizza;
import com.arminzheng.factory.method.pizza.NYStyleClamPizza;
import com.arminzheng.factory.method.pizza.NYStylePepperoniPizza;
import com.arminzheng.factory.method.pizza.NYStyleVeggiePizza;

public class NYPizzaStore extends PizzaStore {

  protected Pizza createPizza(String item) {
    switch (item) {
      case "cheese":
        return new NYStyleCheesePizza();
      case "veggie":
        return new NYStyleVeggiePizza();
      case "clam":
        return new NYStyleClamPizza();
      case "pepperoni":
        return new NYStylePepperoniPizza();
      default:
        return null;
    }
  }
}
