package com.start.defineMybatis.main;
import com.start.defineMybatis.tools.sqlSession.SqlSession;
import com.start.defineMybatis.tools.sqlSession.SqlSessionFactory;
import com.start.defineMybatis.tools.sqlSession.SqlSessionFactoryBuilder;
import com.start.entry.dao.IUserConfig;
import com.start.entry.entity.User;
import com.start.defineMybatis.tools.is.Resources;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 自定义mybatis的框架的各个模式
 */
public class StartDefineMybatis {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("com\\start\\entry\\config\\SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IUserConfig iUser = session.getMapper(IUserConfig.class);
        //使用代理对象执行方法
        List<User> users = iUser.findAllUser();
        for (User user:users){
            System.out.println(user);
        }
        //释放资源
        session.close();
        in.close();
    }
}
