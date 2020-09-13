package com.transaction.anno.transferManagerAllAnno;

import com.transaction.anno.transferManagerAllAnno.service.IAccountService;
import com.transaction.anno.transferManagerAllAnno.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用spring和Junit的整合测试spring的bean.xml的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestTransferManager {
    @Autowired
    private IAccountService accountService;
    @Test//测试转账
    public void testTransfer(){
        accountService.transfer("老吕","老祁",100f);
    }
}
