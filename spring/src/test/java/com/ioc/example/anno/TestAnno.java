package com.ioc.example.anno;
import com.ioc.example.anno.config.SpringConfiguration;
import com.ioc.example.anno.entity.Account;
import com.ioc.example.anno.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestAnno {
    /**ApplicationContext和IAccountService是重复代码块，且不是测试相关的代码可以和sprng进行整合：
     *spring整合junit的配置：
     * 1，导入spring整合Junit的jar包(坐标)
     * 2.使用Junit提供的一个注解将原有的main方法替换成spring提供的
     *      @RunWith
     * 3.告知spring的运行器，spring和ioc创建时基于xml还是注解的，并且说明位置
     *     @ContextConfiguration
     *     属性：location：指定xml文件的位置，加上classpath表示在类路径下
     *           classes：指定注解类所在位置
     *    细节：当我们的spring版本为5.x时，要求我们的junit版本为4.12及以上
     * */
    //private ApplicationContext ac =  new ClassPathXmlApplicationContext("beanAnno.xml");
    /**获取和bean.xml配置一样的配置类
     * AnnotationConfigApplicationContext参数中可以传入多个配置类字解码，他们都是并列关系
     * 传入的配置类之后在配置类中可以省略@Configuration注解
     * */
    //private ApplicationContext ac =  new AnnotationConfigApplicationContext(SpringConfiguration.class);
    //private IAccountService iAccountService = ac.getBean("accountServiceImple",IAccountService.class);
    @Autowired
    private IAccountService iAccountService;
    @Test
    public void testFindAll(){
        //获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到service(业务层对象)
        //IAccountService iAccountService = ac.getBean("accountServiceImple",IAccountService.class);
        //执行方法
        List<Account> accounts = iAccountService.findAll();
        //打印
        for(Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        Account account = iAccountService.findAccountById(2);
        System.out.println(account);
    }
    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(4);
        account.setUname("test11");
        account.setMoney(131415);
        iAccountService.updateAcount(account);
    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setUname("test");
        account.setMoney(12345);
        iAccountService.savaAccount(account);
    }
    @Test
    public void testDelete(){
        iAccountService.deleteAcount(5);
    }
}
