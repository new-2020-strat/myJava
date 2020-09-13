package com.transaction.xml.example;

import com.transaction.xml.example.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试基于xml的事务控制
 */
public class TestTransactionXml {
    private ApplicationContext as;
    private IAccountService accountService;

    @Before
    public void init(){
        as = new ClassPathXmlApplicationContext("com\\transaction\\xml\\example\\bean.xml");
        accountService = as.getBean("accountServiceImple",IAccountService.class);
    }
    @Test//转账测试
    public void TestTransfer(){
        accountService.transfer("老吕","老祁",400f);
    }
}
