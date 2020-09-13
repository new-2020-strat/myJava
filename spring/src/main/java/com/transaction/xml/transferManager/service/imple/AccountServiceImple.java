package com.transaction.xml.transferManager.service.imple;

import com.transaction.xml.transferManager.dao.IAccountDao;
import com.transaction.xml.transferManager.entity.Account;
import com.transaction.xml.transferManager.service.IAccountService;

public class AccountServiceImple implements IAccountService {

    private IAccountDao dao;
    public void setDao(IAccountDao dao) {
        this.dao = dao;
    }

    public Account findAccountById(Integer accountId) {
        //执行操作
        Account account = dao.findAccountById(accountId);
        //返回结果
        return account;
    }

    public void transfer(String sourceName, String targetName, Float money) {
        //执行操作
        //转账业务流程-------将这些操作变成一个数据连接实现事务
        //2.1.根据名称查询转出用户
        Account source = dao.findAccountByName(sourceName);
        //2.2.根据名称查询转入用户
        Account target = dao.findAccountByName(targetName);
        //2.3.转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4.转入用户加钱
        target.setMoney(target.getMoney()+money);
        //2,5.更新转出账户
        dao.updateAccount(source);
        int i = 1/0;
        //2.6.更新转入账户
        dao.updateAccount(target);
    }
}
