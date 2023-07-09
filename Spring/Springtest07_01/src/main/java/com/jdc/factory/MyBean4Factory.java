package com.jdc.factory;

import com.jdc.beans.Bean4;
import org.springframework.beans.factory.FactoryBean;

public class MyBean4Factory implements FactoryBean<Bean4> {
    @Override
    public Bean4 getObject() throws Exception {
        System.out.println("FactoryBean接口的getObject方法");
        return new Bean4();
    }
    @Override
    public Class<?> getObjectType() {
        return Bean4.class;
    }
}
