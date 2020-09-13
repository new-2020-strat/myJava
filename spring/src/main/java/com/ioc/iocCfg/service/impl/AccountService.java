package com.ioc.iocCfg.service.impl;

import com.ioc.iocCfg.dao.IAccountDao;
import com.ioc.iocCfg.service.IAccountService;

/**
 * 模拟调用持久层
 */
public class AccountService implements IAccountService {
    //public IAccountDao iAccountDao = new AccountDao();//耦合
    //改造后
    //public IAccountDao iAccountDao = (IAccountDao) BeanFactoryMulti.getBean("accouintDao");
    public void saveAccount() {
        //iAccountDao.saveAccount();
    }
}
