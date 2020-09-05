package com.multilist;


import com.multilist.dao.IRoleDao;
import com.multilist.entity.Role;
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

public class RoleMain {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IRoleDao iRoletDao;
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
        iRoletDao = session.getMapper(IRoleDao.class);
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
    public void testSelectAllRole()  {
        //5.使用代理对象执行方法
        List<Role> roles = iRoletDao.selectAllRole();
        for (Role role:roles){
            System.out.println(role);
        }
    }

    /**
     * 查询当前角色并且带有该角色所属用户
     */
    @Test
    public void testSelectAllRoleWithUser(){
        List<Role> roles = iRoletDao.selectAllRoleWithUser();
        for (Role role:roles){
            System.out.println(role);
            System.out.println(role.getCustomers().size());
        }
    }
}
