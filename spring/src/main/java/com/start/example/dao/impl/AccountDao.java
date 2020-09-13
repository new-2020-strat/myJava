package com.start.example.dao.impl;

import com.start.example.dao.IAccountDao;

/**
 * 模拟持久层保存账户
 */
public class AccountDao implements IAccountDao {
    public void saveAccount() {
        //此处实际操作数据库保存操作，此处只是模拟业务
        System.out.println("保存账户！！！！");
    }
}
