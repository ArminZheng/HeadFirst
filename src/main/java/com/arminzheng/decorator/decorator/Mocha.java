package com.arminzheng.decorator.decorator;

import com.arminzheng.decorator.Beverage;
import com.arminzheng.decorator.CondimentDecorator;

/**
 * @author Armin Zheng
 * @since 2021-09-07
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + .20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
