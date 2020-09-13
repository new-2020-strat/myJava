package com.ioc.iocAnno.ui;

import com.ioc.iocAnno.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试IOC
 */
public class Client {
    /**
     * 获取ioc容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        //获取ioc核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/ioc/iocAnno/bean.xml");
        //根据id获取对象
        IAccountService iAccountService = (IAccountService)ac.getBean("accountService");
        iAccountService.saveAccount();
        //iAccountService.saveAccount();
       /* //获取通过默认构造器配置的bean
        TestDefaultConstructor tdc = (TestDefaultConstructor)ac.getBean("defaultConstructor");
        tdc.save();
        //获取使用工厂中的方法创建的bean
        TestFactoryMethod tfm = (TestFactoryMethod)ac.getBean("factoryMethod");
        tfm.save();
        //获取使用工厂中的静态方法创建bean
        TestStaticMethod tsm = (TestStaticMethod)ac.getBean("staticMethod");
        tsm.save();*/
    }
}
