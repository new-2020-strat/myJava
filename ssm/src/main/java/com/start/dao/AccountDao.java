package com.start.dao;

import com.start.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层接口
 */
@Repository
public interface AccountDao {
    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存一个账户
     */
    public void saveAccount(Account account);
}
