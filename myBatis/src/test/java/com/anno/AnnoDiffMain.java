package com.anno;

import com.anno.dao.IUserDao;
import com.anno.dao.IUserDaoDiff;
import com.anno.entity.User;
import com.anno.entity.UserDiff;
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
public class AnnoDiffMain {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDaoDiff iUserDaoDiff;
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
        iUserDaoDiff = session.getMapper(IUserDaoDiff.class);

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
        List<UserDiff> users = iUserDaoDiff.findAll();
        for (UserDiff user: users){
            System.out.println(user);
        }
    }
    /**
     * 通过id查询一条
     */
    @Test
    public void testFindById(){
        UserDiff user = iUserDaoDiff.findUserById(26);
        System.out.println(user);
    }

}
