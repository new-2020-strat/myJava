package com.start.Test;
import com.start.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *测试Session对象
 */
public class TestSession {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    private Configuration configuration;
    @Before
    public void init(){
        configuration  = new Configuration().configure("/com/start/config/hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                .buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }
    @After
    public void release(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    @Test//测试一级缓存(session缓存)
    public void testSessionCache(){
        //会发sql语句，存入缓存
        News news1 = (News)session.get(News.class, 1);
        System.out.println(news1);
        //不会发缓存,从缓存中获取
        News news2 = (News)session.get(News.class, 1);
        System.out.println(news2);
    }

    /**
     * refresh()：会强制发送select语句，以session缓存中的对象状态和数据库表中的数据记录一致
     */
    @Test//测试refresh
    public void testRefresh(){
        News news = (News)session.get(News.class, 1);
        System.out.println("news=="+news);
        session.refresh(news);
        System.out.println(news);
    }
    /**
     * 会清理session缓存
     */
    @Test//测试clear()清理缓存
    public void testClear(){
        News news = (News)session.get(News.class, 1);
        System.out.println("news=="+news);
        session.clear();
        News news2 = (News)session.get(News.class, 1);
        System.out.println("news2=="+news2);
    }
    /**
     * flush:数据表中的记录和session缓存中的对象状态保持一致，为了保持一致可能会发送sql语句
     * 在transaction中的commit()方法，先执行flush()再提交事务
     * flush可能会发送sql语句但不会提交事务
     * 注意：在session提交事务或者显式调用flush()方法之前也有可能执行flush操作
     *      1,,在执行HQL或者QBC查询操作之前会先执行flush操作以得到最新数据
     *      2.若表中的数据记录Id是由底层数据库自增方式生成的，则在执行save方法时
     *      就会立即发送insert语句以保证对象的ID值是存在的
     */
    @Test//测试Flush方法
    public void testFlush(){
        News news = (News)session.get(News.class, 1);
        System.out.println("news=="+news);
        news.setAuthor("曹雪芹1");
        News news2 = (News)session.createCriteria(News.class).uniqueResult();
        System.out.println("news2=="+news2);
        session.flush();
        //不会发缓存,从缓存中获取
        News news3 = (News)session.get(News.class, 1);
        System.out.println("news3=="+news3);
    }
}
