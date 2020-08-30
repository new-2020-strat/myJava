package com.start.entry.main;

import com.start.entry.dao.IUserConfig;
import com.start.entry.dao.implDao.ImplIUserConfig;
import com.start.entry.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/**
 * 测试基于自己实现dao接口的mybatis入门
 */
public class StartImplDao {
    public static void main(String[] args) throws IOException {
        //1.读取mybatis的配置文件
        /**相对路径：使用类加载器，他只能加载类所在路径的配置文件
         * 绝对路径：使用servletContext的getRealPath方法**/
        InputStream in = Resources.getResourceAsStream("com\\start\\entry\\config\\SqlMapConfi.xml");
        //2.创建SqlSessionFactory工厂
        /**mybatis使用了构建者模式，builder就是构建者*/
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产dao对象
        IUserConfig iUserConfig = new ImplIUserConfig(factory);
        //5.使用dao对象执行方法
        List<User> users = iUserConfig.findAllUser();
        for (User user:users){
            System.out.println(user);
        }
        //释放资源
        in.close();
    }
}
