package com.jdbcTemplate.jdbcTemplate;
import com.jdbcTemplate.jdbcTemplate.dao.IAccountDao;
import com.jdbcTemplate.jdbcTemplate.entity.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

/**
 * 测试jdbcTemplate的crud的操作
 */
public class TestJdbcTemplate {
    private ApplicationContext ac;
    private IAccountDao accountDao;

    @Before
    public void init(){
        //获取容器
        ac = new ClassPathXmlApplicationContext("com\\jdbcTemplate\\jdbcTemplate\\bean.xml");
        //获取对象
        accountDao = ac.getBean("accountDao", IAccountDao.class);
    }
    @Test//修改
    public void updateAccount(){
        Account account = new Account();
        account.setId(6);
        account.setUname("琪琪");
        account.setMoney(250f);
        accountDao.updateAccount(account);
    }
    @Test//根据id查询
    public void findAccountBuId(){
        Account account = accountDao.findAccountById(6);
        System.out.println(account);
    }
}
