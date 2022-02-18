package com.arminzheng.factory.abstraction.store;

import com.arminzheng.factory.abstraction.*;
import com.arminzheng.factory.abstraction.pizza.VeggiePizza;
import com.arminzheng.factory.abstraction.factory.ChicagoPizzaIngredientFactory;
import com.arminzheng.factory.abstraction.PizzaIngredientFactory;
import com.arminzheng.factory.abstraction.pizza.CheesePizza;
import com.arminzheng.factory.abstraction.pizza.ClamPizza;
import com.arminzheng.factory.abstraction.pizza.PepperoniPizza;

public class ChicagoPizzaStore extends PizzaStore {

  protected Pizza createPizza(String item) {
    Pizza pizza = null;
    PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

    switch (item) {
      case "cheese":
        pizza = new CheesePizza(ingredientFactory);
        pizza.setName("Chicago Style Cheese Pizza");
        break;
      case "veggie":
        pizza = new VeggiePizza(ingredientFactory);
        pizza.setName("Chicago Style Veggie Pizza");
        break;
      case "clam":
        pizza = new ClamPizza(ingredientFactory);
        pizza.setName("Chicago Style Clam Pizza");
        break;
      case "pepperoni":
        pizza = new PepperoniPizza(ingredientFactory);
        pizza.setName("Chicago Style Pepperoni Pizza");
        break;
    }
    return pizza;
  }
}
