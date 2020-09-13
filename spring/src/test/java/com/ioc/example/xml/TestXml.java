package com.ioc.example.xml;

import com.ioc.example.xml.entity.Account;
import com.ioc.example.xml.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestXml {
    //获取容器
    private ApplicationContext ac =  new ClassPathXmlApplicationContext("com/ioc/example/xml/bean.xml");
    //得到service(业务层对象)
    private IAccountService iAccountService = ac.getBean("accountServiceImple",IAccountService.class);
    @Test
    public void testFindAll(){
        List<Account> accounts = iAccountService.findAll();
        for(Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        Account account = iAccountService.findAccountById(2);
        System.out.println(account);
    }
    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(4);
        account.setUname("test11");
        account.setMoney(131415);
        iAccountService.updateAcount(account);

    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setUname("test");
        account.setMoney(12345);
        iAccountService.savaAccount(account);
    }
    @Test
    public void testDelete(){
        iAccountService.deleteAcount(5);
    }
}
