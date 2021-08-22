package com.arminzheng.observer.weather.impl;

import com.arminzheng.observer.weather.Observer;
import com.arminzheng.observer.weather.Subject;

import java.util.ArrayList;

/**
 * @author Armin Zheng
 * @since 2021-05-12
 */
public class WeatherData implements Subject {
    private final ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) { // 未找到为 -1
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        observers.forEach(e -> e.update(temperature, humidity, pressure));
    }

    // public void measurementsChanged() {
    //     notifyObserver();
    // }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
        // measurementsChanged();
    }


}
