package com.transaction.anno.transferManagerAllAnno.dao.imple;
import com.transaction.anno.transferManagerAllAnno.dao.IAccountDao;
import com.transaction.anno.transferManagerAllAnno.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久层实现
 * 可以继承账jdbcDaoSupport使用父类创建的jdbcTemplate对象
 */
@Repository("accountDaoImple")
public class AccountDaoImple  implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
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
