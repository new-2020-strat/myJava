package com.start;

import com.start.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试Spring
 */
public class TestSpring {

    @Test
    public void run1(){
        //加载spring的配置文件
        ApplicationContext ac  = new ClassPathXmlApplicationContext("com/start/applicationContext.xml");
        //获取对象
        AccountService accountService = (AccountService) ac.getBean("accountService");
        //执行方法
        accountService.findAll();
    }
}
