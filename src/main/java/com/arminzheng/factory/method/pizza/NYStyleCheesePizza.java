package com.arminzheng.factory.method.pizza;

import com.arminzheng.factory.method.Pizza;

public class NYStyleCheesePizza extends Pizza {

  public NYStyleCheesePizza() {
    name = "NY Style Sauce and Cheese Pizza";
    dough = "Thin Crust Dough";
    sauce = "Marinara Sauce";

    toppings.add("Grated Reggiano Cheese");
  }
}
