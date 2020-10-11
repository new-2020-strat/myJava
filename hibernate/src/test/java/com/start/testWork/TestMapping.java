package com.start.testWork;

import com.start.entity.Pay;
import com.start.entity.Worker;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;

public class TestMapping {
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
    @Test//测试日期、大文本，二进制类型映射
    public void testDateMapping() throws IOException {
        Worker work = new Worker();
        work.setDate(new Date());
        work.setContent("CONTENT");
        InputStream stream = new FileInputStream("Hydrangeas.jpg");
		Blob image = Hibernate.getLobCreator(session)
				              .createBlob(stream, stream.available());
		work.setImage(image);

		session.save(work);
    }
    @Test//测试映射组成关系
    public void testComponent() throws IOException {
        Worker worker = new Worker();
        worker.setDate(new Date());
        worker.setContent("CONTENT");
        InputStream stream = new FileInputStream("Hydrangeas.jpg");
        Blob image = Hibernate.getLobCreator(session)
                .createBlob(stream, stream.available());
        worker.setImage(image);
        Pay pay = new Pay();
        pay.setMonthlyPay(1000);
        pay.setYearPay(80000);
        pay.setVocationWithPay(5);
        worker.setName("老祁");
        worker.setPay(pay);

        session.save(worker);
    }
}
