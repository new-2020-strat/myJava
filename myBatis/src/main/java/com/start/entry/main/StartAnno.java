package com.start.entry.main;

import com.start.entry.dao.IUserAnno;
import com.start.entry.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试基于注解的mybatis入门
 */
public class StartAnno {
    public static void main(String[] args) throws IOException {
        //1.读取mybatis的配置文件
        /**相对路径：使用类加载器，他只能加载类所在路径的配置文件
         * 绝对路径：使用servletContext的getRealPath方法**/
        InputStream in = Resources.getResourceAsStream("com\\start\\entry\\config\\SqlMapAnno.xml");
        //2.创建SqlSessionFactory工厂
        /**mybatis使用了构建者模式，builder就是构建者*/
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        /**使用工厂sqlSession对象创建dao接口的代理对象
         * openSession(true)若传入一个true值则自动提交事务
         * 解耦，降低类之间的耦合 */
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        /**创建dao实现类使用了代理模式，不修改源码对已有方法增强*/
        IUserAnno iUserAnno = session.getMapper(IUserAnno.class);
        //5.使用代理对象执行方法
        List<User> users = iUserAnno.findAllUser();
        for (User user:users){
            System.out.println(user);
        }
        //释放资源
        session.close();
        in.close();
    }
}
