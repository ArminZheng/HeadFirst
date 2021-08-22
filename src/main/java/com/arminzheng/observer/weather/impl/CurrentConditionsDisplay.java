package com.arminzheng.observer.weather.impl;

import com.arminzheng.observer.weather.DisplayElement;
import com.arminzheng.observer.weather.Observer;
import com.arminzheng.observer.weather.Subject;

/**
 * @author Armin Zheng
 * @since 2021-05-12
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private final Subject weatherData;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and "+ humidity + "% humidity.");
    }
}
