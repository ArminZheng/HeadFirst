package com.arminzheng.decorator;

/**
 * 饮料
 *
 * @author Armin Zheng
 * @since 2021-09-07
 */
public abstract class Beverage {
    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
