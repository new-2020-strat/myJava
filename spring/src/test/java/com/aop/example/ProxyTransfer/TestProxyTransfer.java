package com.aop.example.ProxyTransfer;
import com.aop.example.proxyTransfer.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/aop/example/proxyTransfer/bean.xml")
public class TestProxyTransfer {
    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService as;
    @Test
    public void testFindOne(){
        as.transfer("老祁","老吕",200f);
    }
}
