package com.aop.aop.anno.service.imple;

import com.aop.aop.anno.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImple implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存操作！");
        //int i = 1/0;测试异常通知
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新操作！！");
    }

    public int deleteAccount() {
        System.out.println("执行了删除操作！！");
        return 0;
    }
}
