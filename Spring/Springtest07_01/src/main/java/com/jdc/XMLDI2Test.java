package com.jdc;

import com.jdc.beans.User1;
import com.jdc.beans.User2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLDI2Test {
    public static void main(String[] args) {

        //获取Spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        User2 user1 = (User2) ac.getBean("user2");
        System.out.println(user1);

    }
}
