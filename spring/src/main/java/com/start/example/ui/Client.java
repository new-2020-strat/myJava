package com.start.example.ui;

import com.start.example.factory.BeanFactoryMulti;
import com.start.example.factory.BeanFactorySingle;
import com.start.example.service.IAccountService;

/**
 * 模拟视图层条用业务层
 */
public class Client {
    public static void main(String[] args) {
        //IAccountService iAccountService = new AccountService();//耦合
        //改造后
        IAccountService iAccountService = (IAccountService) BeanFactoryMulti.getBean("accountService");
        /*for (int i=0;i<4;i++){
            System.out.println((IAccountService) BeanFactoryMulti.getBean("accountService"));
        }*/
        for (int i=0;i<4;i++){
            System.out.println((IAccountService) BeanFactorySingle.getBean("accountService"));
        }
        iAccountService.saveAccount();
    }
}
