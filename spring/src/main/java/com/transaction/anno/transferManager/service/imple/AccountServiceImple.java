package com.transaction.anno.transferManager.service.imple;

import com.transaction.anno.transferManager.dao.IAccountDao;
import com.transaction.anno.transferManager.entity.Account;
import com.transaction.anno.transferManager.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountServiceImple")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//只读型事务控制
public class AccountServiceImple implements IAccountService {
    @Autowired
    private IAccountDao dao;

    public Account findAccountById(Integer accountId) {
        //执行操作
        Account account = dao.findAccountById(accountId);
        //返回结果
        return account;
    }
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)//需要的是读写型事务控制
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
        //int i = 1/0;
        //2.6.更新转入账户
        dao.updateAccount(target);
    }
}
