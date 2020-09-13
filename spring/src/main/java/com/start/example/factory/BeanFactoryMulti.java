package com.start.example.factory;

import java.io.InputStream;
import java.util.Properties;

/*创建bean对象的工厂，
    bean：      在计算机英语中有重复使用组件的含义
*   Javabean：  和我们的实体类不等，是用Java编写的可重用组件，
*               他就是创建service和dao对象的
*  创建对象的思路： 1.需要一个配置文件来配置service和dao
*                       配置内容：全限定类名(key-value)
*                   2.通过读取配置文件中的内容，反射创建对象
*配置文件可以是xml或者properties
* */

/*这是多例模式，多例模式每次创建时都会从新初始化类成员变量
* 单例模式在创建时只会创建一个对象，类中成员变量只初始化一次
* */
public class BeanFactoryMulti {
    //解析properties文件
    private static Properties properties;//创建一个Properties对象
    //使用静态代码块给properties对象赋值
    static {
        try {
            //实例化对象
            properties = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactoryMulti.class.getClassLoader().getResourceAsStream("com/start/example/bean.properties");
            properties.load(in);
        } catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }
    //根据bean的名称获取对象(该对象是多例模式的)
    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = properties.getProperty(beanName);
            //每次都使用默认构造函数创建对象
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }
}
