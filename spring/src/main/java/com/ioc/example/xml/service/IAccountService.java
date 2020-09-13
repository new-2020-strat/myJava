package com.ioc.example.xml.service;
import com.ioc.example.xml.entity.Account;

import java.util.List;

//业务层接口
public interface IAccountService {
    List<Account> findAll();//查询所有
    Account findAccountById(Integer accountId);//通过id查一个
    void savaAccount(Account account);//保存
    void updateAcount(Account account);//更新
    void deleteAcount(Integer accountId);//删除
}
