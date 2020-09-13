package com.aop.example.dynamicProxy.cglib;
import org.springframework.cglib.proxy.*;
import java.lang.reflect.Method;

//模拟一个消费者
public class Client {
    public static void main(final String[] args) {
        final Producer producer = new Producer();
        //producer.saleProduct(1000f);
        /**
         * 动态代理，基于子类的动态代理
         * 特点：字节码随用随创建，随用随加载
         * 作用：在不改变源码的基础上对方法增强
         * 分类：
         *      1.基于接口的动态代理
         *      2.基于子类的动态代理
         *  基于子类的动态代理：
         *      所涉及的类Enhancer
         *      提供者，第三方cglib库
         *  如何创建代理对象：
         *      使用Enhancer类中的create方法
         *      要求：被代理类不能是在一个最终类
         * create方法中的参数：
         *      class:字节码
         *          用于指定被代理对象的字节码
         *
         *      callback：用于提供增强的代码，固定写法
         *          让我们写如何代理，我们一般写它的一个实现类，通常情况是匿名内部类，但不是必须
         *          我们一般写的是该接口的一个子接口实现类，methodInterceptor
         */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *被代理对象的任何方法都会经过该方法
             * @param proxy
             * @param method
             * @param args
             * 以上三个参数和基于接口的动态代理的invoke方法的参数是一样的
             * @param methodProxy  当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                /**编写增强代码区*/
                Object returnValue = null;
                //获取方法执行的参数
                Float money = (Float)args[0];
                //判断当前方法是否是销售
                if("saleProduct".equals(method.getName())){
                    returnValue = method.invoke(producer,money*0.8f);
                }
                return returnValue;//匿名内部类访问外部成员，外部成员用final修饰
            }
        });
        cglibProducer.saleProduct(1200f);
    }
}
