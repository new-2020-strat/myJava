package com.ioc.iocCfg.util;

import java.util.*;

/**
 *使用注解提供注入属性
 */
public class TestStaticMethod {
    private String[] mystr;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myPro;

    public static TestStaticMethod getTestStaticMethod(){
        return new TestStaticMethod();
    }
    public void save(){
        System.out.println("使用注解复杂方式注入");
        System.out.println(Arrays.toString(mystr));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myPro);
    }
    public void setMystr(String[] mystr) {
        this.mystr = mystr;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyPro(Properties myPro) {
        this.myPro = myPro;
    }


}
