package ru.test.springintegrationwebservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {   
    
    public static void main(String[] args) {        
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
    }
    
}
