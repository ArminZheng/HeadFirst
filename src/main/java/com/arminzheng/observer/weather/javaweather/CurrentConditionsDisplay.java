package com.arminzheng.observer.weather.javaweather;

import com.arminzheng.observer.weather.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Armin Zheng
 * @since 2021-05-19
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.print("temperature = " + temperature);
        System.out.println(", humidity = " + humidity);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
