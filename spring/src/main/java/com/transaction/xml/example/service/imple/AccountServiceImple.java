package com.transaction.xml.example.service.imple;

import com.transaction.xml.example.dao.IAccountDao;
import com.transaction.xml.example.entity.Account;
import com.transaction.xml.example.service.IAccountService;

import java.util.List;

public class AccountServiceImple implements IAccountService {
    private IAccountDao dao;
    public void setDao(IAccountDao dao) {
        this.dao = dao;
    }

    public List<Account> findAll() {
            //执行操作
            List<Account> accounts = dao.findAll();
            //返回结果
            return accounts;
    }
    public Account findAccountById(Integer accountId) {
            //执行操作
            Account account = dao.findAccountById(accountId);
            //返回结果
            return account;
    }

    public void savaAccount(Account account) {
            //执行操作
            dao.savaAccount(account);
    }

    public void updateAcount(Account account) {
            //执行操作
            dao.updateAcount(account);
    }

    public void deleteAcount(Integer accountId) {
            //执行操作
            dao.deleteAcount(accountId);
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
            dao.updateAcount(source);
            //int i = 1/0;
            //2.6.更新转入账户
            dao.updateAcount(target);
    }
}
