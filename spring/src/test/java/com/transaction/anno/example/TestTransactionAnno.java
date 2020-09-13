package com.transaction.anno.example;

import com.transaction.anno.example.entity.Account;
import com.transaction.anno.example.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransactionAnno {
    private ApplicationContext as;
    private IAccountService accountService;

    @Before
    public void init(){
        as = new ClassPathXmlApplicationContext("com\\transaction\\anno\\example\\bean.xml");
        accountService = as.getBean("accountServiceImple", IAccountService.class);
    }
    @Test//修改测试
    public void TestTransfer(){
        Account account = new Account();
        account.setId(6);
        account.setUname("小祁");
        account.setMoney(450f);
        accountService.updateAcount(account);
    }
    @Test//测试转账
    public void TestTransfre(){
        accountService.transfer("老吕","老祁",100f);
    }
}
