package com.aop.example.dynamicProxy.interfaceProxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

//模拟一个消费者
public class Client {
    public static void main(final String[] args) {
        final Producer producer = new Producer();
        //producer.saleProduct(1000f);

        /**
         * 动态代理，基于接口的动态代理
         * 特点：字节码随用随创建，随用随加载
         * 作用：在不改变源码的基础上对方法增强
         * 分类：
         *      1.基于接口的动态代理
         *      2.基于子类的动态代理
         *  基于接口的动态代理：
         *      所涉及的类proxy
         *      提供者，jdk官方
         *  如何创建代理对象：
         *      使用Proxy类中的newProxyInstance方法
         *      要求：被代理对象必须实现一个接口，否则无法创建
         * newProxyInstance方法中的参数：
         *      ClassLoad:类加载器
         *          用于加载代理对象的字节码，和被代理对象使用相同的类加载器，固定写法
         *      Class[]：字节码数组
         *          让代理对象和被代理对象实现相同的方法
         *      InvocationHandler：用于提供增强的代码，固定写法
         *          让我们写如何代理，我们一般写它的一个实现类，通常情况是匿名内部类，但不是必须
         */
        IProduce iProduce = (IProduce) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(), new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法，
                     * @param o  代理对象的引用
                     * @param method  当前执行的方法
                     * @param objects 当前执行方法所需的参数
                     * @return          和被代理对象方法具有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        /**编写增强代码区*/
                        Object returnValue = null;
                        //获取方法执行的参数
                        Float money = (Float)objects[0];
                        //判断当前方法是否是销售
                        if("saleProduct".equals(method.getName())){
                             returnValue = method.invoke(producer,money*0.8f);
                        }
                        return returnValue;//匿名内部类访问外部成员，外部成员用final修饰
                    }
                });
        iProduce.saleProduct(1000f);
    }
}
