package com.multilist.dao;
import com.multilist.entity.Account;
import com.multilist.entity.AccountUser;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询account表所有通过uid
     * @return
     */
    public List<Account> selectAccountById(Integer uid);

    /**
     * 查询account表所有
     * @return
     */
    public List<Account> selectAllAccount();

    /**
     * 查询所有账户并且带有该账户的所属用户的姓名和地址
     * @return
     */
    public List<AccountUser> selectAllAccountWithUser();

    /**
     * 查询所有账户并且带有该账户的所属用户所有信息
     * @return
     */
    public List<Account> selectAllAccountWithAllUser();

    /**
     * 查询所有账户并且带有该账户的所属用户所有信息(延迟加载)
     * @return
     */
    public List<Account> selectAllAccountWithAllUserBuffer();



}
