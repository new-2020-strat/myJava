package com.crud.config.main;

import com.crud.config.dao.IUser;
import com.crud.config.entity.Users;
import com.crud.config.entity.User;
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

/**
 * 测试增删改查(crud)
 */
public class TestCrud {
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
         in = Resources.getResourceAsStream("com\\crud\\config\\sqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
         builder = new SqlSessionFactoryBuilder();
         factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();//传入一个true值可设为事务自动提交
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
        user.setUserName("老吕");
        user.setSex('男');
        user.setBirthday(new Date());
        user.setAddress("贵州");
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
        user.setSex('女');
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
        Integer nun = iUser.deleteUser(41);
        session.commit();
        System.out.println("删除数量:"+nun);
    }

    /**
     * 模糊查询测试
     */
    @Test
    public void TestQueryByDim(){
        List<User> users = iUser.queryByDim("%祁%");//执行xml配置方式的findall方法
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test //OGNL表达式查询
    public  void findUser(){
        Users users = new Users();
        User user = new User();
        user.setUserName("老祁");
        users.setUser(user);
        List<User> list = iUser.findUser(users);
        for(User u:list){
            System.out.println(u);
        }
    }

    /**
     * 查询所有(实体类个别名不一致)
     */
    @Test
    public void testFieldDifferent(){

    }
}
