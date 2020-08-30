package com.start.entry.dao.implDao;

import com.start.entry.dao.IUserConfig;
import com.start.entry.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * 编写dao接口的实现类
 */
public class ImplIUserConfig implements IUserConfig {
    private SqlSessionFactory factory;
    public ImplIUserConfig(SqlSessionFactory factory){
        this.factory = factory;
    }
    public List<User> findAllUser() {
        //使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //使用session对象执行查询表user所有的方法
        List<User> users = session.selectList("com.start.entry.dao.IUserConfig.findAllUser");
        //关闭资源
        session.close();
        //返回结果集
        return users;
    }
}
