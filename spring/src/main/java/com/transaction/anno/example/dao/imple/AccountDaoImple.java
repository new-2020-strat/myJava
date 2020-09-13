package com.transaction.anno.example.dao.imple;
import com.transaction.anno.example.dao.IAccountDao;
import com.transaction.anno.example.entity.Account;
import com.transaction.anno.example.util.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.List;

@Repository("dao")
public class AccountDaoImple implements IAccountDao {
    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtils connectionUtils;

    public List<Account> findAll() {
        try {
            return runner.query(connectionUtils.getThreadLocal(),"select * from account_spring",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query(connectionUtils.getThreadLocal(),"select * from account_spring where id= ? ",new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void savaAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadLocal(),"insert into account_spring(uname,money) values(?,?)",account.getUname(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAcount(Account account) {
        try {
            runner.update(connectionUtils.getThreadLocal()," update account_spring set uname=?,money=? where id=?",account.getUname(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAcount(Integer accountId) {
        try {
            runner.update(connectionUtils.getThreadLocal(),"delete from account_spring where id = ?",accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = runner.query(connectionUtils.getThreadLocal(),"select * from account_spring where uname= ? ",new BeanListHandler<Account>(Account.class),accountName);
            if (accounts==null || accounts.size()==0){
                return null;
            }else if (accounts.size()>1){
                throw new RuntimeException("返回结果集不为1");
            } else {
                return accounts.get(0);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
