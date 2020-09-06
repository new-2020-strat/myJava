package com.anno;

import com.anno.dao.IAccountDao;
import com.anno.dao.IAccountDaoMulti;
import com.anno.dao.IUserDao;
import com.anno.entity.Account;
import com.anno.entity.User;
import org.apache.ibatis.annotations.Select;
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
 * 注解方式测试多表操作
 */
public class AnnomainMulti {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDaoMulti iAccountDaoMulti;
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
        iAccountDaoMulti = session.getMapper(IAccountDaoMulti.class);

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
     * 查询所有用户并且带有该用户所属账户信息
     */
    @Test
    public void testFindAllAccountsWithUser(){
        List<Account> aconuts = iAccountDaoMulti.findAllAconutsWithUser();
        for (Account account:aconuts){
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 查询所有账户并且带有该账户所属用户信息
     */
    @Test
    public void testFindAllUsersWithAccount(){
        List<User> users = iAccountDaoMulti.findAllUsersWithAccount();
        for (User user:users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void TestCacheLevel(){
        SqlSession session1 = factory.openSession();
        IAccountDao iAccountDao1 = session1.getMapper(IAccountDao.class);
        Account account1 = iAccountDao1.findAccountById(26);
        System.out.println(account1);
        session1.close();//关闭一级缓存

        SqlSession session2 = factory.openSession();
        IAccountDao iAccountDao2 = session2.getMapper(IAccountDao.class);
        Account account2 = iAccountDao2.findAccountById(26);
        System.out.println(account2);
        session2.close();//关闭一级缓存

    }
}
