package com.aop.aop.anno.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类
 *
 * 当用注解方式进行事务控制时，四种通知无法控制执行顺序
 * 应选择用环绕通知
 */
@Component("logger")
@Aspect//表示当前类是一个切面
public class Logger {
    /**
     * 定义切入点表达式
     */
    @Pointcut("execution(public void com.aop.aop.anno.service.imple.AccountServiceImple.saveAccount())")
    public void pt1(){}
    @Pointcut("execution(public void com.aop.aop.anno.service.imple.AccountServiceImple.updateAccount(int))")
    public void pt2(){}


    /**
     * 用于打印日志，计划然其在切入点执行之前执行(切入点方法就是业务层方法)
     * 前置通知
     */
    @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知：logger类中的beforePrintLog开始记录日志了！！");

    }
    /**
     * 后置通知
     */
    @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知：logger类中的afterReturning开始记录日志了！！");

    }

    /**
     *异常通知
     */
    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知：logger类中的afterThrowing开始记录日志了！！");

    }

    /**
     * 最终通知
     */
    @After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知：logger类中的after开始记录日志了！！");

    }
    /**
     * 环绕通知
     * 发现：
     *      当在配置文件中配置环绕通知之后，切入点方法没有执行，而通知点方法执行了
     * 分析：
     *      和动态代理比较，动态代理的环绕通知有明确的切入点方法调用，而此时没有
     * 解决：
     *      在spring框架中有一个接口，proceedingJoinPoint，该接口有一个方法叫proceed
     *      此方法就相当于明确调用切入点方法，该接口可以作为环绕通知方法的参数，在程序执行时
     *      spring会提供该接口的一个实现类供我们使用
     * 环绕通知的解释：
     *      是spring为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     */
    @Around("pt2()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object returnValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需的参数
            System.out.println("环绕通知：logger类中的aroundPrintLog开始记录日志了...........前置通知");
            returnValue = pjp.proceed(args);  //明确调用业务层方法(切入点方法)
            System.out.println("环绕通知：logger类中的aroundPrintLog开始记录日志了...........后置通知");
            return returnValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知：logger类中的aroundPrintLog开始记录日志了...........异常通知");
            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("环绕通知：logger类中的aroundPrintLog开始记录日志了..........最终通知");
        }
    }
}
