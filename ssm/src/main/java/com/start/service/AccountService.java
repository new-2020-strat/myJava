package com.start.service;

import com.start.entity.Account;

import java.util.List;

/**
 * 业务层接口
 */
public interface AccountService {
    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户
     */
    public void saveAccount(Account account);
}
