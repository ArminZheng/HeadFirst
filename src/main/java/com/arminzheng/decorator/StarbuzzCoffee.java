package com.arminzheng.decorator;

import com.arminzheng.decorator.beverage.DarkRoast;
import com.arminzheng.decorator.beverage.Espresso;
import com.arminzheng.decorator.beverage.HouseBlend;
import com.arminzheng.decorator.condiment.decorator.Mocha;
import com.arminzheng.decorator.condiment.decorator.Soy;
import com.arminzheng.decorator.condiment.decorator.Whip;

/**
 * @author Armin Zheng
 * @since 2021-09-07
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " $" + espresso.cost());
        Beverage darkRoast = new DarkRoast();
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);
        System.out.println(darkRoast.getDescription() + " $" + darkRoast.cost());

        Beverage houseBlend = new HouseBlend();
        houseBlend = new Soy(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Whip(houseBlend);
        System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());
    }
}
