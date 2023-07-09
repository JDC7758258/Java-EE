package com.jdc;

import com.jdc.beans.User1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLDI1Test {
    public static void main(String[] args) {

        //获取Spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        User1 user1 = (User1) ac.getBean("user1");
        System.out.println(user1);

    }
}
