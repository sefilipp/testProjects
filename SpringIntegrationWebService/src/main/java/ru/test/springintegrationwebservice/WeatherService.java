package ru.test.springintegrationwebservice;

import ru.test.springintegrationwebservicegenerated.Weather;
import ru.test.springintegrationwebservicegenerated.WeatherReturn;
import ru.test.springintegrationwebservicegenerated.WeatherSoap;

public class WeatherService {
    
    public static String getWeather(){
        
        Weather weather = new Weather();
        WeatherSoap weatherSoap = weather.getWeatherSoap();
        WeatherReturn weatherReturn = weatherSoap.getCityWeatherByZIP("80010");
        return weatherReturn.getCity() + " " + weatherReturn.getTemperature();
    }
    
}
