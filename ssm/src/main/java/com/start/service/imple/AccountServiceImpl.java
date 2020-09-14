package com.start.service.imple;

import com.start.dao.AccountDao;
import com.start.entity.Account;
import com.start.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层执行查询所有");
        return accountDao.findAll();
    }
    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层执行保存账户");
        accountDao.saveAccount(account);
    }
}
