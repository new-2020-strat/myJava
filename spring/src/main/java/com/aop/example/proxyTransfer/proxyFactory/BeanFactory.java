package com.aop.example.proxyTransfer.proxyFactory;
import com.aop.example.proxyTransfer.service.IAccountService;
import com.aop.example.proxyTransfer.util.TransactionManager;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

//用于创建代理对象的工厂
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager transactionManager;
    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
    public final void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    //获取Service的代理对象
    public IAccountService getAccountService() {
        Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(), new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     *
                     * @param o      ：
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        try {
                            //开启事务
                            transactionManager.transactionBegin();
                            //执行操作
                            returnValue = method.invoke(accountService,args);
                            //提交事务
                            transactionManager.commit();
                            //返回结果
                            return returnValue;
                        } catch (Exception e) {
                            //回滚事务
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //释放连接
                            transactionManager.release();
                        }
                    }
                });
        return this.accountService;
    }
}
