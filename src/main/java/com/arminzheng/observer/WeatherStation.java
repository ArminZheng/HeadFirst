package com.arminzheng.observer;

import com.arminzheng.observer.weather.impl.CurrentConditionsDisplay;
import com.arminzheng.observer.weather.impl.HeatIndexDisplay;
import com.arminzheng.observer.weather.impl.WeatherData;

/**
 * @author Armin Zheng
 * @since 2021-05-12
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,29.4f);
    }
}
