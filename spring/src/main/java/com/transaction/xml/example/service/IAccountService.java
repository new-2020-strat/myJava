package com.transaction.xml.example.service;

import com.transaction.xml.example.entity.Account;

import java.util.List;

//注解业务层接口
public interface IAccountService {
    List<Account> findAll();//查询全部
    Account findAccountById(Integer accountId);//通过Id查询
    void savaAccount(Account account);//保存
    void updateAcount(Account account);//更新
    void deleteAcount(Integer accountId);//删除
    /**
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    //转账
    void transfer(String sourceName, String targetName, Float money);
}
