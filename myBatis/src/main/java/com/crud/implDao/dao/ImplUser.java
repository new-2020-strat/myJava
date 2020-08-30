package com.crud.implDao.dao;

import com.crud.implDao.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * 手动实现doa接口的方式
 */
public class ImplUser implements IUser{
    private SqlSessionFactory factory;
    public ImplUser(SqlSessionFactory factory){
        this.factory = factory;
    }

    /**
     * 查询所有
     * @return
     */
    public List<User> selectAll() {
        //通过SqlSessionFactory工厂获取SqlSession对象
        SqlSession session = factory.openSession();
        //调用session对象中的方法实现对数据库的操作
        List<User> users = session.selectList("com.crud.implDao.dao.IUser.selectAll");//配置文件中方法的全路径名称
        //释放资源
        session.close();
        return users;
    }

    /**
     * 插入一条数据
     * @param user
     * @return
     */
    public Integer insertUser(User user) {
        //通过SqlSessionFactory工厂获取SqlSession对象
        SqlSession session = factory.openSession();
        //调用session对象中的方法实现对数据库的操作
        Integer num = session.insert("com.crud.implDao.dao.IUser.insertUser", user);//配置文件中方法的全路径名称
        //释放资源
        session.close();
        return num;
    }

    /**
     * 更新操作
     * @param user
     * @return
     */
    public Integer updateUser(User user) {
        //通过SqlSessionFactory工厂获取SqlSession对象
        SqlSession session = factory.openSession();
        //调用session对象中的方法实现对数据库的操作
        Integer num = session.update("com.crud.implDao.dao.IUser.updateUser", user);//配置文件中方法的全路径名称
        //释放资源
        session.close();
        return num;
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    public Integer deleteUser(Integer id) {
        //通过SqlSessionFactory工厂获取SqlSession对象
        SqlSession session = factory.openSession();
        //调用session对象中的方法实现对数据库的操作
        Integer num = session.delete("com.crud.implDao.dao.IUser.deleteUser",id);//配置文件中方法的全路径名称
        //释放资源
        session.close();
        return num;
    }

    /**
     * 模糊查询
     * @param username
     * @return
     */
    public List<User> queryByDim(String username) {
        //通过SqlSessionFactory工厂获取SqlSession对象
        SqlSession session = factory.openSession();
        //调用session对象中的方法实现对数据库的操作
        List<User> users = session.selectOne("com.crud.implDao.dao.IUser.queryByDim",username);//配置文件中方法的全路径名称
        return users;
    }

    /**
     * 查询一条
     * @param id
     * @return
     */
    public User selectOne(Integer id) {
        //通过SqlSessionFactory工厂获取SqlSession对象
        SqlSession session = factory.openSession();
        //调用session对象中的方法实现对数据库的操作
        User user = session.selectOne("com.crud.implDao.dao.IUser.selectOne",id);//配置文件中方法的全路径名称
        return user;
    }

}
