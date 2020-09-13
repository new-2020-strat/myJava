package com.ioc.iocAnno.dao.impl;

import com.ioc.iocAnno.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 模拟持久层保存账户
 */
@Repository("accountDao")
public class AccountDao implements IAccountDao {
    public void saveAccount() {
        //此处实际操作数据库保存操作，此处只是模拟业务
        System.out.println("保存账户！！！！");
    }
}
