package com.arminzheng.factory.abstraction.store;

import com.arminzheng.factory.abstraction.pizza.PepperoniPizza;
import com.arminzheng.factory.abstraction.Pizza;
import com.arminzheng.factory.abstraction.PizzaIngredientFactory;
import com.arminzheng.factory.abstraction.PizzaStore;
import com.arminzheng.factory.abstraction.pizza.VeggiePizza;
import com.arminzheng.factory.abstraction.factory.NYPizzaIngredientFactory;
import com.arminzheng.factory.abstraction.pizza.CheesePizza;
import com.arminzheng.factory.abstraction.pizza.ClamPizza;

public class NYPizzaStore extends PizzaStore {

  protected Pizza createPizza(String item) {
    Pizza pizza = null;
    PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

    switch (item) {
      case "cheese":
        pizza = new CheesePizza(ingredientFactory);
        pizza.setName("New York Style Cheese Pizza");
        break;
      case "veggie":
        pizza = new VeggiePizza(ingredientFactory);
        pizza.setName("New York Style Veggie Pizza");
        break;
      case "clam":
        pizza = new ClamPizza(ingredientFactory);
        pizza.setName("New York Style Clam Pizza");
        break;
      case "pepperoni":
        pizza = new PepperoniPizza(ingredientFactory);
        pizza.setName("New York Style Pepperoni Pizza");
        break;
    }
    return pizza;
  }
}
