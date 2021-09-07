package com.arminzheng.decorator;

/**
 * @author Armin Zheng
 * @since 2021-09-07
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return 3;
    }
}
