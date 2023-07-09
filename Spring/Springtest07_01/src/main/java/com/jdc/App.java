package com.jdc;

import com.jdc.service.OrderService;
import com.jdc.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class App {

    public static void main(String[] args) {
        //一：BeanFactory接口操作实例
        //BeanFactory默认是第一次获取对象时，创建对象。
//        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("E:\\Java EE企业级应用开发教程\\Spring\\Springtest07\\src\\main\\resources\\applicationContext.xml"));
//        OrderService orderService = beanFactory.getBean(OrderService.class);
//        System.out.println(orderService);

        //二：ApplicationContext接口实例
        //是BeanFactory的子接口，在容器初始化时，就创建Bean了
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        Object bean1 = ac.getBean("bean1");
        Object bean1_1 = ac.getBean("bean1");
        //Object bean2 = ac.getBean("bean2");

        System.out.println(bean1);
        System.out.println(bean1_1);
        //System.out.println(bean2);
    }
}
