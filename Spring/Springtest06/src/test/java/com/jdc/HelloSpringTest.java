package com.jdc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringTest {
    public static void main(String[] args) {
        //1.获取spring
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.从spring获取对象
        HelloSpring helloSpring = (HelloSpring) ac.getBean("helloSpring");

        //3.调用对象的方法
        helloSpring.show();
    }
}