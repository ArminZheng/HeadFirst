package com.arminzheng.observer.service;

/**
 * @author Armin Zheng
 * @since 2021-05-12
 */
public interface Observer { // 所有的观察者都必须实现update方法

    /**
     * 当气象值改变时，主题会把观测值当作方法的参数传入观测者中
     *
     * @param temperature 气温
     * @param humidity 湿度
     * @param pressure 气压
     * @author Armin Zheng
     * @since 2021-05-13
     */
    public void update(float temperature, float humidity, float pressure);
}
