package org.example;


import org.example.controller.Controller;
import org.example.springConfig.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Controller controller= context.getBean("controller",Controller.class);
        controller.start();

    }
}