package com.aop.example.dynamicProxy.interfaceProxy;
//一个生产者
public class Producer implements IProduce{
    /**
     * 销售产品
     * @param money
     */
    public void saleProduct(Float money){
        System.out.println("销售产品并拿到钱"+money);
    }

    /**
     * 售后服务
     * @param money
     */
    public void afterService(Float money){
        System.out.println("售后服务拿到钱"+money);
    }

}
