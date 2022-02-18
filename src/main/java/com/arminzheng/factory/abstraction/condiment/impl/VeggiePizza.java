package com.arminzheng.factory.abstraction.condiment.impl;

import com.arminzheng.factory.abstraction.Pizza;
import com.arminzheng.factory.abstraction.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {
  PizzaIngredientFactory ingredientFactory;

  public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;
  }

  protected void prepare() {
    System.out.println("Preparing " + name);
    dough = ingredientFactory.createDough();
    sauce = ingredientFactory.createSauce();
    cheese = ingredientFactory.createCheese();
    veggies = ingredientFactory.createVeggies();
  }
}
