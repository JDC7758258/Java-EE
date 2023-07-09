package com.jdc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonTest {
    public static void main(String[] args) {

        //获取Spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取容器中的Bean
        Object bean1 = ac.getBean("bean1");
        Object bean2 = ac.getBean("bean1");
        System.out.println(bean1==bean2);

    }
}
