package com.anno;

import com.anno.dao.IUserDao;
import com.anno.entity.User;
import com.crud.config.entity.Users;
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
 * 注解开发测试
 */
public class AnnoMain {
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
        in = Resources.getResourceAsStream("com\\anno\\sqlMapAnno.xml");
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
     * 测试查询全部
     */
    @Test
    public void testfindAll(){
        List<User> users = iUserDao.findAll();
        for (User user: users){
            System.out.println(user);
        }
    }

    /**
     * 保存插入测试
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setId(99);
        user.setUserName("小刘");
        user.setSex('女');
        user.setBirthday(new Date());
        user.setAddress("贵州");
        iUserDao.insert(user);
        session.commit();
    }

    /**
     * 更新操作
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(99);
        user.setUserName("小祁");
        iUserDao.update(user);
        session.commit();
    }
    /**
     * 删除
     */
    @Test
    public void testDelete(){
        iUserDao.delete(99);
        session.commit();
    }
    /**
     * 通过id查询一条
     */
    @Test
    public void testFindById(){
        User user = iUserDao.findById(26);
        System.out.println(user);
    }
    /**
     * 通过名称模糊查询
     */
    @Test
    public void testFindByUserName(){
        List<User> users = iUserDao.findByName("祁");
        for (User user:users){
            System.out.println(user);
        }
    }
    /**
     * 获取总记录数
     */
    @Test
    public void testGetTotal(){
        Integer total = iUserDao.getTotal();
        System.out.println("总记录数=="+total);
    }
}
