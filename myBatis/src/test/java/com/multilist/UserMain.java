package com.multilist;

import com.multilist.entity.User;
import com.multilist.dao.IUserDao;
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

public class UserMain {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao iUserDao;
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
        iUserDao = session.getMapper(IUserDao.class);
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
     * 一对多，一个用户有多个账户的查询所有用户
     */
    @Test
    public void testSelectAllUserWithAllAccount(){
        List<User> users = iUserDao.selectAllUserWithAllAccount();
        for (User user:users){
            System.out.println(user);
            System.out.println("-----");
            System.out.println(user.getAccounts());
        }
    }
}
