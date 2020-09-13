package com.transaction.program;

import com.transaction.program.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 测试基于编程式事务控制
 */
public class TestProgramTransactionManager {
    private ApplicationContext as;
    private IAccountService accountService;
    @Before
    public void init(){
        as = new ClassPathXmlApplicationContext("com\\transaction\\program\\bean.xml");
        accountService = as.getBean("accountServiceImple", IAccountService.class);
    }
    @Test//转账测试
    public void TestTransfer(){
            accountService.transfer("老祁","老吕",100f);
        }
}
