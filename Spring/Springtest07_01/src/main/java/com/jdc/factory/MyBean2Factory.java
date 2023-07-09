package com.jdc.factory;

import com.jdc.beans.Bean2;

public class MyBean2Factory {
    public static Bean2 createBean(){
        System.out.println("工厂的静态方法");
        return new Bean2();
    }
}
