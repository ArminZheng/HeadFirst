package com.arminzheng.decorator;

/**
 * @author Armin Zheng
 * @since 2021-09-07
 */
public abstract class CondimentDecorator extends Beverage {

    /* 装饰器模式使用到了抽象类的特性（规范+模版），装饰类会继承抽象类，并组合抽象类。*/
    protected Beverage beverage;

    public abstract String getDescription();
}