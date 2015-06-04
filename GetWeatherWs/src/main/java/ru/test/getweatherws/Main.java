package ru.test.getweatherws;

import globalweather.GetCityWeatherByZIP;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MessageChannel transformationChannel = context.getBean("inputChannel", MessageChannel.class);

        GetCityWeatherByZIP weatherRequest = context.getBean("weatherRequest", GetCityWeatherByZIP.class);

        transformationChannel.send(new GenericMessage<GetCityWeatherByZIP>(weatherRequest));
        
        System.out.println("TESTTTT");        
    }

}
