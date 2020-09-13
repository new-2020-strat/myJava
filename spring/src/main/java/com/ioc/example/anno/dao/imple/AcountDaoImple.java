package com.ioc.example.anno.dao.imple;
import com.ioc.example.anno.dao.IAccountDao;
import com.ioc.example.anno.entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Repository("accountDaoImple")
public class AcountDaoImple implements IAccountDao {
    @Autowired
    private QueryRunner runner;
   /* public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }*/
    public List<Account> findAll() {
        try {
            return runner.query("select * from account_spring",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("select * from account_spring where id= ? ",new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void savaAccount(Account account) {
        try {
            runner.update("insert into account_spring(uname,money) values(?,?)",account.getUname(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAcount(Account account) {
        try {
            runner.update(" update account_spring set uname=?,money=? where id=?",account.getUname(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAcount(Integer accountId) {
        try {
            runner.update("delete from account_spring where id = ?",accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
