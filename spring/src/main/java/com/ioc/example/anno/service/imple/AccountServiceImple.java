package com.ioc.example.anno.service.imple;
import com.ioc.example.anno.dao.IAccountDao;
import com.ioc.example.anno.entity.Account;
import com.ioc.example.anno.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service("accountServiceImple")
public class AccountServiceImple implements IAccountService {
    @Autowired
    private IAccountDao dao;
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
