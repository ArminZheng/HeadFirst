package com.arminzheng.observer;

import com.arminzheng.observer.weather.javaweather.CurrentConditionsDisplay;
import com.arminzheng.observer.weather.javaweather.ForecastDisplay;
import com.arminzheng.observer.weather.javaweather.WeatherData;

/**
 * @author Armin Zheng
 * @since 2021-05-19
 */
public class JavaWeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);

        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.4f);

    }
}
