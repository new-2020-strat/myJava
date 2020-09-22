package com.start.Test;

import com.start.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * 测试对象的四种状态
 */
public class TestJavaBean {
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

    /**
     *save()方法
     * 1.使一个临时对象变为持久化对象
     * 2.为对象分配ID
     * 3.在flush缓存时会发送一条insert语句
     * 4.在执行save()之前Id值无效
     * 5.持久化对象的ID不可修改(通过id和数据表中的记录对应)
     */
    @Test
    public void testSave(){
        News news = new News();
        news.setTitle("三国演义");
        news.setAuthor("罗贯中");
        news.setDate(new Date());

        System.out.println(news);
        session.save(news);
        System.out.println(news);
    }

    /**
     * persist()也会执行insert操作
     * 在persist()之前若对象已经有了id值，则不会执行insert语句，抛出异常
     */
    @Test
    public void testPersist(){
        News news = new News();
        news.setTitle("水浒传");
        news.setAuthor("施耐庵");
        news.setDate(new Date());
        news.setId(200);
        session.persist(news);
    }

    /**
     *
     */
    @Test
    public void testGet(){
        News news = (News) session.get(News.class,1);
        System.out.println(news);
    }

    /**get() VS load()
     * 1.执行get()方法会立即加载对象。而执行load()方法，若不使用该对象
     *      则不会立即执行查询操作，而返回一个代理对象
     *      get是立即检索(立即加载)，load是延迟检索(懒加载)
     * 2.若数据库表中没有对应的记录，session也没有被关闭，同时使用对象时
     *      get：返回null，
     *      load：若不使用该对象的任何属性,没问题,若需要初始化了,抛出异常
     * 3.load方法可能会抛出异常：LazyInitializationException,在初始化代理对象之前关闭了session
     */
    @Test
    public void testLoad(){
        News news = (News)session.load(News.class,1);
        session.close();//抛出异常：LazyInitializationException
        System.out.println(news.getDesc());

    }

    /**
     *1.若更行一个持久化对象不需要显示调用update方法
     *      因为在调用transaction的commit方法时会先执行session的flush方法
     * 2.更新一个游离对象需要调用session的update方法，可以把一个游离状态变为持久化对象
     *      --无论要更新的对象和数据表中的是否一致都会发update语句
     *      --  可在.hbm.xml文件中的class节点设置select-before-update=true(默认为false)防止发送update无效语句
     *3.若在数据库表中没有该条记录进行update操作会抛出异常
     * 4.当update()方法关联一个游离对象，如果在session的缓存中已经有相同的OID的持久化对象，会抛出异常，因为在session缓存中
     *      不能有两个OID相同的持久化对象
     */
    @Test
    public void testUpdate(){
        News news = (News) session.get(News.class,1);
        news.setAuthor("曹雪芹aa");
    }

    /**
     * 1.若OID不为null,但数据表中还没有和其对应的记录，会抛出异常
     * 2.了解：OID值等于id的unsaved-value属性值得对象，也被认为是一种游离对象
     */
    @Test
    public void testSaveOrUpdate(){
        News news = new News("西游记","吴承恩",new Date());
        //news.setId(5);
        session.saveOrUpdate(news);
    }

    /**
     * 1.执行删除操作，只要OID和数据库表中一条记录对应，就会执行delete操作
     * 2.若OID在数据表中没有对应记录，则抛出异常
     * 3.可以通过设置hibernate配置文件hibernate.use_identifier_rollback为true
     * 使删除对象后把其OID置为null
     */
    @Test
    public void testDelete(){
        News news = (News) session.get(News.class,2222);
        session.delete(news);

    }

    /**
     * evict：从session缓存中把指定持久化对象移除
     */
    @Test
    public void testEvict(){
        News news1 = (News)session.get(News.class,1);
        News news2 = (News)session.get(News.class,1);

        news1.setTitle("aa");
        news2.setTitle("bb");
        session.evict(news2);//news2无法发送update语句

    }

    /**
     *使用远原生的connection调用存储过程
     */
    @Test
    public void testDoWork(){
        session.doWork(new Work() {
            public void execute(Connection connection) throws SQLException {
                //获取到jdbc中的connection对象
                System.out.println(connection);
                //通过connection调用存储过程
            }
        });
    }
}
