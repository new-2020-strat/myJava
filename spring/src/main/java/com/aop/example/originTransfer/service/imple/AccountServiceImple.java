package com.aop.example.originTransfer.service.imple;

import com.aop.example.originTransfer.dao.IAccountDao;
import com.aop.example.originTransfer.entity.Account;
import com.aop.example.originTransfer.service.IAccountService;
import com.aop.example.originTransfer.util.TransactionManager;

import java.util.List;
public class AccountServiceImple implements IAccountService {
    private IAccountDao dao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    public void setDao(IAccountDao dao) {
        this.dao = dao;
    }

    public List<Account> findAll() {
        try {
            //开启事务
            transactionManager.transactionBegin();
            //执行操作
            List<Account> accounts = dao.findAll();
            //提交事务
            transactionManager.commit();
            //返回结果
            return accounts;
        }catch (Exception e){
            //回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            transactionManager.release();
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            //开启事务
            transactionManager.transactionBegin();
            //执行操作
            Account account = dao.findAccountById(accountId);
            //提交事务
            transactionManager.commit();
            //返回结果
            return account;
        }catch (Exception e){
            //回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            transactionManager.release();
        }
    }

    public void savaAccount(Account account) {
        try {
            //开启事务
            transactionManager.transactionBegin();
            //执行操作
            dao.savaAccount(account);
            //提交事务
            transactionManager.commit();
            //返回结果
            //return accounts;
        }catch (Exception e){
            //回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            transactionManager.release();
        }
    }

    public void updateAcount(Account account) {
        try {
            //开启事务
            transactionManager.transactionBegin();
            //执行操作
            dao.updateAcount(account);
            //提交事务
            transactionManager.commit();
            //返回结果
            //return accounts;
        }catch (Exception e){
            //回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            transactionManager.release();
        }
    }

    public void deleteAcount(Integer accountId) {
        try {
            //开启事务
            transactionManager.transactionBegin();
            //执行操作
            dao.deleteAcount(accountId);
            //提交事务
            transactionManager.commit();
            //返回结果
            //return accounts;
        }catch (Exception e){
            //回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            transactionManager.release();
        }

    }

    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //开启事务
            transactionManager.transactionBegin();
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
            //提交事务
            transactionManager.commit();
        }catch (Exception e){
            //回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            transactionManager.release();
        }

    }
}
