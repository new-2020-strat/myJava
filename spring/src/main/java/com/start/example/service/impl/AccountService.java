package com.start.example.service.impl;

import com.start.example.dao.IAccountDao;
import com.start.example.factory.BeanFactoryMulti;
import com.start.example.service.IAccountService;

/**
 * 模拟调用持久层
 */
public class AccountService implements IAccountService {
    //public IAccountDao iAccountDao = new AccountDao();//耦合
    //改造后
    public IAccountDao iAccountDao = (IAccountDao) BeanFactoryMulti.getBean("accouintDao");
    public void saveAccount() {
        iAccountDao.saveAccount();
    }
}
