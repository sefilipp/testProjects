package ru.test.getweatherws;

import globalweather.GetCityWeatherByZIPResponse;
import globalweather.WeatherReturn;
import org.springframework.xml.transform.StringResult;


public class Logger {

    public void log(String message){
        System.out.println("Logger: " + message);
    }

}
