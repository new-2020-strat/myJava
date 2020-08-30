package com.crud.config.main;
import com.crud.config.dao.IUserFieldDiff;
import com.crud.config.entity.UserFieldDiff;
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

/**
 * 测试实体类属性名表字段名不一致
 */
public class TestFieldDiff {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserFieldDiff iUser;

    /**
     * 测试方法执行之前先执行
     * @throws IOException
     */
    @Before
    public void init() throws IOException{
        //1.读取mybatis的配置文件
        in = Resources.getResourceAsStream("com\\crud\\sqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        iUser = session.getMapper(IUserFieldDiff.class);
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
     * 查询所有(表字段取别名)
     */
    @Test
    public void TestSelectAllUserNamed(){
        List<UserFieldDiff> userFieldDiffs = iUser.selectAllUserNamed();
        for(UserFieldDiff userFieldDiff:userFieldDiffs){
            System.out.println(userFieldDiff);
        }

    }

    /**
     * 查询所有(建立映射关系)
     */
    @Test
    public void TestSelectAllUserMap(){
        List<UserFieldDiff> userFieldDiffs = iUser.selectAllUserMap();
        for(UserFieldDiff userFieldDiff:userFieldDiffs){
            System.out.println(userFieldDiff);
        }
    }
}
