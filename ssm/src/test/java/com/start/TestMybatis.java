package com.start;

import com.start.dao.AccountDao;
import com.start.entity.Account;
import com.start.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试mybatis
 */
public class TestMybatis {
    @Test
    public void run1() throws IOException {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("com/start/mysqlConfig.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //执行方法
        /*List<Account> accounts = accountDao.findAll();
        for (Account account:accounts){
            System.out.println(account);
        }*/
        Account account = new Account();
        account.setId(3);
        account.setName("小川");
        account.setMoney(30.0);
        accountDao.saveAccount(account);
        session.commit();
        //关闭资源
        session.close();
        is.close();

    }
}
