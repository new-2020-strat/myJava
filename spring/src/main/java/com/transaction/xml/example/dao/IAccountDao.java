package com.transaction.xml.example.dao;

import com.transaction.xml.example.entity.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();//查询全部
    Account findAccountById(Integer accountId);//通过Id查询
    void savaAccount(Account account);//保存
    void updateAcount(Account account);//更新
    void deleteAcount(Integer accountId);//删除
    /**
     * 根据名称查询账户
     * @param accountName 账户名称
     * @return  如果有唯一一个返回值就返回，没有返回值就返回null
     * 如果返回结果集超过一个则跑出异常
     */
    Account findAccountByName(String accountName);
}
