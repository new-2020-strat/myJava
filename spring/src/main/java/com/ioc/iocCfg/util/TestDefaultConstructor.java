package com.ioc.iocCfg.util;

import java.util.Date;

/**
 * 默认构造方式注入属性
 */
public class TestDefaultConstructor {
    private String name;
    private Integer age;
    private Date birthday;

    public TestDefaultConstructor(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void save(){
        System.out.println("构造器方式注入成功：name="+name+" age="+age+" birthday="+birthday);
    }
}
