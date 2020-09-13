package com.ioc.example.xml.service.imple;
import com.ioc.example.xml.dao.IAccountDao;
import com.ioc.example.xml.entity.Account;
import com.ioc.example.xml.service.IAccountService;

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
}
