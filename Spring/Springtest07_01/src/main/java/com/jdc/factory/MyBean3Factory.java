package com.jdc.factory;

import com.jdc.beans.Bean3;

public class MyBean3Factory {
    public MyBean3Factory() {
        System.out.println("实例化工厂的构造方法");
    }

    public Bean3 createBean(){
        return new Bean3();
    }
}
