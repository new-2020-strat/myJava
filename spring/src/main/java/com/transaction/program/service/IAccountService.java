package com.transaction.program.service;

import com.transaction.program.entity.Account;

/**
 * 业务层接口
 */
public interface IAccountService {
    Account findAccountById(Integer accountId);//通过Id查询
    /**
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    //转账
    void transfer(String sourceName, String targetName, Float money);
}
