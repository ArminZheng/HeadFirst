package com.arminzheng.decorator.decorator;

import com.arminzheng.decorator.Beverage;
import com.arminzheng.decorator.CondimentDecorator;

/**
 * @author Armin Zheng
 * @since 2021-09-07
 */
public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return .1 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}
