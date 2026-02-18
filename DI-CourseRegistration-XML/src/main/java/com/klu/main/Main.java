package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.model.CourseRegistration;

public class MainAPP{

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        CourseRegistration cr =
                (CourseRegistration) context.getBean("corseReg");

        cr.display();
    }
}
