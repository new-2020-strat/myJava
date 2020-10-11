package com.start.TestNews;

import com.start.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import java.util.Date;

/**
 * 测试入门案例
 */
public class TestStart {
    /**
     * 测试入门
     */
    @Test
    public void test(){
        //1.创建SessionFactory对象
        SessionFactory sessionFactory = null;
        Session session = null;
        //创建Configuration对象，对应hibernate的基本配置和对象映射信息
        Configuration configuration  = new Configuration().configure("/com/start/config/hibernate.cfg.xml");
        //4.0以前这样创建
        //sessionFactory = configuration.buildSessionFactory();
        /**
         * 在hibernate4.2中我们使用如下方式创建ServiceRegistry对象
         * ServiceRegistry serviceRegistry= new ServiceRegistrybuilder()
         * .applySettings(configuration.getProperties()).buildServiceRegistry();
         *
         * 在hibernate5.0.2中buildServiceRegistry方法被替换掉了我们使用如下方式去创建ServiceRegistry对象
         * ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder()
         * .applySettings(configuration.getProperties()).build();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory();
         */
        ServiceRegistry serviceRegistry =
                new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                        .buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        //2.创建session对象
        session = sessionFactory.openSession();
        //3.开启事务
        Transaction transaction = session.beginTransaction();
        //4.保存操作
        //News news = new News("红楼梦","曹雪芹",new Date());
        News news = new News();
        news.setTitle("红楼梦");
        news.setAuthor("曹雪芹");
        news.setDate(new Date());
        session.save(news);
        //5.提交事务
        transaction.commit();
        //6.关闭session
        session.close();
        //关闭SessionFactory对象
        sessionFactory.close();
    }
}
