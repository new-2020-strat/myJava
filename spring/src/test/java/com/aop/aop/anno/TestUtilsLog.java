package com.aop.aop.anno;

import com.aop.aop.anno.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试日志打印
 */
public class TestUtilsLog {
    //获取容器
   private ApplicationContext applicationContext;
    //获取对象
   private IAccountService accountService;

   @Before
   public void init(){
       applicationContext = new ClassPathXmlApplicationContext("com/aop/aop/anno/bean.xml");
       accountService = (IAccountService)applicationContext.getBean("accountService");
   }
   @Test
    public void testSave() {
        //执行方法
        accountService.saveAccount();
    }
    @Test
    public void testAroundAdvice(){
        accountService.updateAccount(1);
    }
}
