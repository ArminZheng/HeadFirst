package com.arminzheng.decorator.beverage;

import com.arminzheng.decorator.Beverage;

/**
 * @author Armin Zheng
 * @since 2021-09-07
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    static Double pay = .89;

    @Override
    public double cost() {
        return .89;
    }
}
