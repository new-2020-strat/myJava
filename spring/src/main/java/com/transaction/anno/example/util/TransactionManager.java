package com.transaction.anno.example.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，包括开启事务，提交事务，回滚事务，释放连接
 */
@Component("transactionManager")
@Aspect//定义切面
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(public void com.transaction.anno.example.service.imple.AccountServiceImple.updateAcount(..))")
    public void pt1(){}
    @Pointcut("execution(public void com.transaction.anno.example.service.imple.AccountServiceImple.transfer(..))")
    public void pt2(){}

    /**
     * 开启事务
     */
    @Before("pt1()")
    public void transactionBegin(){
        try {
            connectionUtils.getThreadLocal().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
    @AfterReturning("pt1()")
    public void commit(){
        try {
            connectionUtils.getThreadLocal().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    @AfterThrowing("pt1()")
    public void rollback(){
        try {
            connectionUtils.getThreadLocal().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 释放连接
     */
    @After("pt1()")
    public void release(){
        try {
            connectionUtils.getThreadLocal().close();//归还到连接池中
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt2()")//使用注解方式控制事务时，一般用环绕通知方式控制
    public Object aroundPrintLog(ProceedingJoinPoint pjp) throws SQLException {
        Object returnValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需的参数
            System.out.println("环绕通知：logger类中的aroundPrintLog开始记录日志了...........前置通知");
            connectionUtils.getThreadLocal().setAutoCommit(false);
            returnValue = pjp.proceed(args);  //明确调用业务层方法(切入点方法)
            System.out.println("环绕通知：logger类中的aroundPrintLog开始记录日志了...........后置通知");
            connectionUtils.getThreadLocal().commit();
            return returnValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知：logger类中的aroundPrintLog开始记录日志了...........异常通知");
            connectionUtils.getThreadLocal().rollback();
            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("环绕通知：logger类中的aroundPrintLog开始记录日志了..........最终通知");
            connectionUtils.getThreadLocal().close();//归还到连接池中
            connectionUtils.removeConnection();
        }
    }
}
