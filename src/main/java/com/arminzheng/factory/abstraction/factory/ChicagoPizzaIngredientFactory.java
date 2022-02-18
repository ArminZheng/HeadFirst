package com.arminzheng.factory.abstraction.factory;

import com.arminzheng.factory.abstraction.*;
import com.arminzheng.factory.abstraction.condiment.*;
import com.arminzheng.factory.abstraction.condiment.impl.*;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

  public Dough createDough() {
    return new ThickCrustDough();
  }

  public Sauce createSauce() {
    return new PlumTomatoSauce();
  }

  public Cheese createCheese() {
    return new MozzarellaCheese();
  }

  public Veggies[] createVeggies() {
    Veggies veggies[] = {new BlackOlives(), new Spinach(), new Eggplant()};
    return veggies;
  }

  public Pepperoni createPepperoni() {
    return new SlicedPepperoni();
  }

  public Clams createClam() {
    return new FrozenClams();
  }
}
