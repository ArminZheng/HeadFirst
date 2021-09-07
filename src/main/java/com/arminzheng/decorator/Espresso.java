package com.arminzheng.decorator;

/**
 * @author Armin Zheng
 * @since 2021-09-07
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
