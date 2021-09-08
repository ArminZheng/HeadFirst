package com.arminzheng.decorator;

/**
 * @author Armin Zheng
 * @since 2021-09-07
 */
public abstract class CondimentDecorator extends Beverage {

    protected Beverage beverage;

    public abstract String getDescription();
}