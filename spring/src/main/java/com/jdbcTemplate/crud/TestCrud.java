package com.jdbcTemplate.crud;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
/**
 * 测试jdbcTemplate的crud的操作
 */
public class TestCrud {
    private ApplicationContext ac;
    private JdbcTemplate jdbcTemplate;

    @Before
    public void init(){
        //获取容器
        ac = new ClassPathXmlApplicationContext("com\\jdbcTemplate\\crud\\bean.xml");
        //获取对象
        jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
    }
    @Test//保存
    public void saveAccount(){
        jdbcTemplate.execute("insert into account_spring(uname,money) values('琪琪',2000)");
    }
    @Test//修改
    public void updateAccount(){
        jdbcTemplate.update("update account_spring set uname=?,money=? where id=?","小琪",10000,6);
    }
    @Test//删除
    public void deleteAccount(){
        jdbcTemplate.update("delete from account_spring where id=?",3);
    }
    @Test//查询所有
    public void findAllAccount(){
        List<Account> accounts = jdbcTemplate.query("select * from account_spring",new AccountRowMap());
        //List<Account> accounts = jdbcTemplate.query("select * from account_spring where money>?",new BeanPropertyRowMapper<Account>(Account.class),100);
        for (Account account:accounts){
            System.out.println(account);
        }
    }
    @Test//查询一个
    public void findAccountById(){
        List<Account> accounts = jdbcTemplate.query("select * from account_spring where id=?",new BeanPropertyRowMapper<Account>(Account.class),1);
        System.out.println(accounts.isEmpty()?"没有数据":accounts.get(0));
    }
    @Test//返回一行一列
    public void getNum(){
        //查询返回一行一列(但不加group by子句)
        Integer num = jdbcTemplate.queryForObject("select count(*) from account_spring where money>?",Integer.class,100);
        System.out.println(num);
    }
}
