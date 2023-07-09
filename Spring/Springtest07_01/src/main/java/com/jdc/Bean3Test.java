package com.jdc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//*****实例化工厂的构造方法*****
public class Bean3Test {
    public static void main(String[] args) {

        //获取Spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取容器中的Bean
        Object bean1 = ac.getBean("bean3");
        System.out.println(bean1);

    }
}
