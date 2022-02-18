package com.arminzheng.factory.method.store;

import com.arminzheng.factory.method.*;
import com.arminzheng.factory.method.pizza.ChicagoStyleCheesePizza;
import com.arminzheng.factory.method.pizza.ChicagoStyleClamPizza;
import com.arminzheng.factory.method.pizza.ChicagoStylePepperoniPizza;
import com.arminzheng.factory.method.pizza.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

  protected Pizza createPizza(String item) {
    switch (item) {
      case "cheese":
        return new ChicagoStyleCheesePizza();
      case "veggie":
        return new ChicagoStyleVeggiePizza();
      case "clam":
        return new ChicagoStyleClamPizza();
      case "pepperoni":
        return new ChicagoStylePepperoniPizza();
      default:
        return null;
    }
  }
}
