package com.arminzheng.factory.simple.pizza;

import com.arminzheng.factory.simple.Pizza;

public class PepperoniPizza extends Pizza {
  public PepperoniPizza() {
    name = "Pepperoni Pizza";
    dough = "Crust";
    sauce = "Marinara sauce";
    toppings.add("Sliced Pepperoni");
    toppings.add("Sliced Onion");
    toppings.add("Grated parmesan cheese");
  }
}
