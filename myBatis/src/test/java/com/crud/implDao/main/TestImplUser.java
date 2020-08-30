package com.crud.implDao.main;

import com.crud.implDao.dao.IUser;
import com.crud.implDao.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestImplUser {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUser iUser;

    /**
     * 测试方法执行之前先执行
     * @throws IOException
     */
    @Before
    public void init() throws IOException{
        //1.读取mybatis的配置文件
        in = Resources.getResourceAsStream("com\\crud\\implDao\\sqlMapImplDao.xml");
        //2.创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        iUser = session.getMapper(IUser.class);

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
     */
    @Test
    public void selectAll()  {
        //5.使用代理对象执行方法
        List<User> users = iUser.selectAll();
        for (User user:users){
            System.out.println(user);
        }
    }
    /**
     * 测试插入方法
     */
    @Test
    public void TestInsertUser() {
        User user = new User();
        user.setUserName("小婷");
        user.setSex('女');
        user.setBirthday(new Date());
        user.setAddress("云南");
        //5.使用代理对象执行方法
        Integer number = iUser.insertUser(user);
        //提交事务
        session.commit();
        System.out.println("插入数量："+number);
    }

    /**
     * 测试更新(通过名字修改性别)
     */
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setUserName("老吕");
        user.setSex('男');
        //5.使用代理对象执行方法
        Integer num = iUser.updateUser(user);
        //提交事务
        session.commit();
        System.out.println("修改数量："+num);
    }

    /**
     * 删除操作(通过id删除)
     */
    @Test
    public void testDeleteUser(){
        Integer nun = iUser.deleteUser(44);
        session.commit();
        System.out.println("删除数量:"+nun);
    }
    /**
     * 模糊查询测试
     */
    @Test
    public void testQueryByDim(){
        List<User> users = iUser.queryByDim("%祁%");
        for(User user:users){
            System.out.println(user);
        }
    }

    /**
     * 测试查询一条
     */
    @Test
    public void testSelectOne(){
        User user = iUser.selectOne(26);
        System.out.println(user);
    }

}
