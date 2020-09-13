package com.ioc.example.anno.dao;


import com.ioc.example.anno.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();//查询所有
    Account findAccountById(Integer accountId);//通过id查一个
    void savaAccount(Account account);//保存
    void updateAcount(Account account);//更新
    void deleteAcount(Integer accountId);//删除
}
