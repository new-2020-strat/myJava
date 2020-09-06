package com.multilist;

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

public class UserMainCache {
    //1.读取mybatis的配置文件
    private InputStream is;
    //2.创建SqlSessionFactory工厂
    private SqlSessionFactoryBuilder sfb;
    private SqlSessionFactory sf;

    @Before
    public void init() throws IOException {
        //1.读取mybatis的配置文件
         is = Resources.getResourceAsStream("com/multilist/sqlMapMultilist.xml");
        //2.创建SqlSessionFactory工厂
        sfb = new SqlSessionFactoryBuilder();
        sf = sfb.build(is);
    }
    @After
    public void close() throws IOException {
        is.close();

    }

    /**
     * 一对多，一个用户有多个账户的查询所有用户(一对多延迟加载)
     */
    @Test
    public void testSelectUsers1() throws IOException {
        SqlSession session1 = sf.openSession();
        IUserDao iUserDao1 = session1.getMapper(IUserDao.class);
        iUserDao1.selectUsers();
        session1.close();//清除一级缓存

        SqlSession session2 = sf.openSession();
        IUserDao iUserDao2 = session2.getMapper(IUserDao.class);
        iUserDao2.selectUsers();
        session2.close();//清除一级缓存
    }
}
