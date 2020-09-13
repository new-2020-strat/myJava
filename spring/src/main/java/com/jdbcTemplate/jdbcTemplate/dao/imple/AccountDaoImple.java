package com.jdbcTemplate.jdbcTemplate.dao.imple;
import com.jdbcTemplate.jdbcTemplate.entity.Account;
import com.jdbcTemplate.jdbcTemplate.dao.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 账户的持久层实现
 * 可以继承账jdbcDaoSupport使用父类创建的jdbcTemplate对象
 */
public class AccountDaoImple implements IAccountDao {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Account findAccountById(Integer id) {
        List<Account> accounts = jdbcTemplate.query("select * from account_spring where id=?",new BeanPropertyRowMapper<Account>(Account.class),id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> accounts = jdbcTemplate.query("select * from account_spring where uname=?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if (accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account_spring set uname=?,money=? where id=?",account.getUname(),account.getMoney(),account.getId());
    }

}
