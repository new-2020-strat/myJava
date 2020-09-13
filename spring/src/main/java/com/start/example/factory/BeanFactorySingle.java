package com.start.example.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactorySingle {
    //解析properties文件
    private static Properties properties;//创建一个Properties对象

    //定义一个Map来存放要创建的对象，我们称之为容器
    private static Map<String,Object> beans;

    //使用静态代码块给properties对象赋值
    static {
        try {
            //实例化对象
            properties = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactoryMulti.class.getClassLoader().getResourceAsStream("com/start/example/bean.properties");
            properties.load(in);
            //实例化容器
            beans = new HashMap<String,Object>();
            //取出properties配置文件中的所有key，返回值是一个枚举
            Enumeration keys = properties.keys();
            //遍历枚举
            while (keys.hasMoreElements()) {
                //获取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //将key和value存入容器Map中
                beans.put(key, value);
            }
        } catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }
    //根据bean的名称获取对象(该对象是单例模式的)
    public static Object getBean(String beanName){
        return beans.get(beanName);//单例模式
    }
}
