package com.aop.example.proxyTransfer.service.imple;
import com.aop.example.proxyTransfer.dao.IAccountDao;
import com.aop.example.proxyTransfer.entity.Account;
import com.aop.example.proxyTransfer.service.IAccountService;
import com.aop.example.proxyTransfer.util.TransactionManager;
import java.util.List;

public class AccountServiceImple implements IAccountService {
    private IAccountDao dao;
    public void setDao(IAccountDao dao) {
        this.dao = dao;
    }

    public List<Account> findAll() {
       return dao.findAll();
    }

    public Account findAccountById(Integer accountId) {
       return dao.findAccountById(accountId);
    }

    public void savaAccount(Account account) {
        dao.savaAccount(account);
    }

    public void updateAcount(Account account) {
        dao.updateAcount(account);
    }

    public void deleteAcount(Integer accountId) {
        dao.deleteAcount(accountId);

    }

    public void transfer(String sourceName, String targetName, Float money) {
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
        int i = 1/0;
        //2.6.更新转入账户
        dao.updateAcount(target);
    }
}
