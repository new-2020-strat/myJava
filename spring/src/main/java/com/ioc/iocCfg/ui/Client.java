package com.ioc.iocCfg.ui;

import com.ioc.iocCfg.service.IAccountService;
import com.ioc.iocCfg.util.TestDefaultConstructor;
import com.ioc.iocCfg.util.TestFactoryMethod;
import com.ioc.iocCfg.util.TestStaticMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 测试IOC
 */
public class Client {
    /**
     * 获取ioc容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        /**
         * ApplicationContext常用的三个实现类
         *      ClassPathXmlApplicationContext：加载类路径下的配置文件，要求配置文件必须在类路径下
         *      FileSystemXmlApplicationContext:加载磁盘任意路径的配置文件(必须有访问权限)
         *      AnnotationConfigApplicationContext:用于读取注解配置的容器
         *核心容器两个接口引发的问题
         *      1. ApplicationContext：在单例模式适用
         *              在构建容器时，采用的策略是立即加载模式，即只要读取完配置文件就立即加载配置文件中配置的对象
         *      2.BeanFactory：在多例模式适用
         *              在构建容器时，采用的策略是懒加载模式,什么时候根据id获取对象了什么时候开始加载
         */
        //获取ioc核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/ioc/iocCfg/bean.xml");
        //根据id获取对象
        IAccountService iAccountService = (IAccountService)ac.getBean("accountService");
        //获取iAccountService对象方式完全一样
        //IAccountService iAccountService = ac.getBean("accountService",IAccountService.class);
        System.out.println(iAccountService);
        //iAccountService.saveAccount();

        //获取通过默认构造器配置的bean
        TestDefaultConstructor tdc = (TestDefaultConstructor)ac.getBean("defaultConstructor");
        tdc.save();
        //获取使用工厂中的方法创建的bean
        TestFactoryMethod tfm = (TestFactoryMethod)ac.getBean("factoryMethod");
        tfm.save();
        //获取使用工厂中的静态方法创建bean
        TestStaticMethod tsm = (TestStaticMethod)ac.getBean("staticMethod");
        tsm.save();
    }
}
