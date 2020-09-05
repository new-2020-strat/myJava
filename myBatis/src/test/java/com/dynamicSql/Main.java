package com.dynamicSql;

import com.dynamicSql.dao.IUser;
import com.dynamicSql.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试动态sql
 */
public class Main {
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
        in = Resources.getResourceAsStream("com/dynamicSql/sqlMapDynamicSql.xml");
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


    @Test//测试if标签
    public void testSelectUserByCondition(){
        User user = new User();
        user.setUserName("老祁");
        List<User> users = iUser.selectUserByCondition(user);
        for(User u:users){
            System.out.println(u);
        }
    }
    @Test//测试foreach
    public void testSelectUserByIdList(){
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(26);
        ids.add(43);
        List<User> users = iUser.selectUserByIdList(ids);
        for(User u:users){
            System.out.println(u);
        }
    }


}
