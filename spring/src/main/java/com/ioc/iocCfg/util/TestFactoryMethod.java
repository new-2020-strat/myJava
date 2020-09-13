package com.ioc.iocCfg.util;
import java.util.Date;

/**
 * set方式注入属性
 */
public class TestFactoryMethod {
    private String name;
    private Integer age;
    private Date birthday;

    public void save(){
        System.out.println("set方式注入成功：name="+name+" age="+age+" birthday="+birthday);
    }
    public TestFactoryMethod getTestFactoryMethod(){
        return new TestFactoryMethod();
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
