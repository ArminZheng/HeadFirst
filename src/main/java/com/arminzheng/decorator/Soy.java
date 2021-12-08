package com.arminzheng.decorator;

/**
 * @author Armin Zheng
 * @since 2021-09-07
 */
public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        // 先将装饰类组合的抽象类的方法执行了。（这里的抽象类，在执行过程中被构造器赋值了）
        // 再执行自己装饰类本身的小九九。
        return beverage.cost() + .12;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
