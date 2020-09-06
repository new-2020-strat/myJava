package com.multilist;

import com.multilist.dao.IAccountDao;
import com.multilist.entity.Account;
import com.multilist.entity.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountMain {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao iAccountDao;
    /**
     * 测试方法执行之前先执行
     * @throws IOException
     */
    @Before
    public void init() throws IOException{
        //1.读取mybatis的配置文件
        in = Resources.getResourceAsStream("com/multilist/sqlMapMultilist.xml");
        //2.创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();//传入一个true值可设为事务自动提交
        //4.使用SqlSession创建Dao接口的代理对象
        iAccountDao = session.getMapper(IAccountDao.class);
    }

    /**
     * 测试方法执行之后执行
     * @throws IOException
     */
    @After
    public void destroy() throws IOException {
        //释放资源
        session.close();
        in.close();
    }
    /**
     * 查询所有
     * 查询账户时获取该账户所属的用户信息
     */
    @Test
    public void testSelectAll()  {
        //5.使用代理对象执行方法
        List<Account> accounts = iAccountDao.selectAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
    }

    /**
     * 查询所有账户并且带有该账户的所属用户的姓名和地址
     */
    @Test
    public void testelectAllAccountWithUser(){
        List<AccountUser> accountUsers = iAccountDao.selectAllAccountWithUser();
        for (AccountUser accountUser:accountUsers){
            System.out.println(accountUser);
        }
    }

    /**
     * 查询所有账户并且带有该账户的所属用户所有信息
     */
    @Test
    public void testSelectAllAccountWithAllUser(){
        List<Account> accounts = iAccountDao.selectAllAccountWithAllUser();
        for (Account account:accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 查询所有账户并且带有该账户的所属用户所有信息(延迟加载)
     */
    @Test
    public void testSelectAllAccountWithAllUserBuffer(){
        List<Account> accounts = iAccountDao.selectAllAccountWithAllUserBuffer();
        /*for (Account account:accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }*/
    }

}
