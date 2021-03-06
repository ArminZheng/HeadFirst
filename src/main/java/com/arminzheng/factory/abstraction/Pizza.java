package com.arminzheng.factory.abstraction;

import com.arminzheng.factory.abstraction.condiment.*;

public abstract class Pizza {
  protected String name; // 名称: 在store.createPizza中被设置

  protected Dough dough; // 生面团
  protected Sauce sauce; // 酱，调味汁
  protected Veggies[] veggies; // 素菜
  protected Cheese cheese; // 奶酪
  protected Pepperoni pepperoni; // 意大利辣肉肠
  protected Clams clam; // 蚌，蛤蜊

  public abstract void prepare();

  public void bake() {
    System.out.println("Bake for 25 minutes at 350");
  }

  public void cut() {
    System.out.println("Cutting the pizza into diagonal slices");
  }

  public void box() {
    System.out.println("Place pizza in official PizzaStore box");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("---- ").append(name).append(" ----\n");
    if (dough != null) {
      result.append(dough);
      result.append("\n");
    }
    if (sauce != null) {
      result.append(sauce);
      result.append("\n");
    }
    if (cheese != null) {
      result.append(cheese);
      result.append("\n");
    }
    if (veggies != null) {
      for (int i = 0; i < veggies.length; i++) {
        result.append(veggies[i]);
        if (i < veggies.length - 1) {
          result.append(", ");
        }
      }
      result.append("\n");
    }
    if (clam != null) {
      result.append(clam);
      result.append("\n");
    }
    if (pepperoni != null) {
      result.append(pepperoni);
      result.append("\n");
    }
    return result.toString();
  }
}
