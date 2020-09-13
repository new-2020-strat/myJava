package com.aop.example.originTransfer;
import com.aop.example.originTransfer.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransfer {
    //获取容器
    private ApplicationContext ac =  new ClassPathXmlApplicationContext("com/aop/example/originTransfer/bean.xml");
    //得到service(业务层对象)
    private IAccountService iAccountService = ac.getBean("accountServiceImple", IAccountService.class);

    @Test
    public void testFindOne(){
        iAccountService.transfer("老祁","老吕",200f);
    }
}
