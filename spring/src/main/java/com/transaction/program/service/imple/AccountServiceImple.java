package com.transaction.program.service.imple;

import com.transaction.program.dao.IAccountDao;
import com.transaction.program.entity.Account;
import com.transaction.program.service.IAccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImple implements IAccountService {
    //事务模板对象
    private TransactionTemplate transactionTemplate;
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

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
    /**
     * 编程试事务管理(不推荐使用，每个方法都要使用模板对象出现大量重复代码)
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    public void transfer(final String sourceName, final String targetName, final Float money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
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
                return null;
            }
        });
    }
}
