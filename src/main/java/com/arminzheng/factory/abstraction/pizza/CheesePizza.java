package com.arminzheng.factory.abstraction.pizza;

import com.arminzheng.factory.abstraction.Pizza;
import com.arminzheng.factory.abstraction.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
  PizzaIngredientFactory ingredientFactory;

  public CheesePizza(PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;
  }

  protected void prepare() {
    System.out.println("Preparing " + name);
    dough = ingredientFactory.createDough();
    sauce = ingredientFactory.createSauce();
    cheese = ingredientFactory.createCheese();
  }
}
