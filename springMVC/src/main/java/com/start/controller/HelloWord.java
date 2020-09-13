package com.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//控制器类
@Controller
@RequestMapping(path = "example")
public class HelloWord {
    /**
     * 入门案例(HelloWorld)
     * @return
     */
    @RequestMapping(path = "/hello")
    public String sayHelloWorld(){
        System.out.println("helloWorld!!!");
        return "hello";
    }

    /**
     * RequestMapping的作用
     *     1.用于建立请求url和处理请求方法之间的对应关系
     *     2.可以作用在方法或者在类上
     * 属性：value和path作用一样，指定访问路径
     *      method：指定请求方式，例如get，post(数组)
     *      params:限定请求参数条件(必须传一个userName参数)
     *      headers：限制请求头
     *
     * @return
     */
    @RequestMapping(path = "/testRequestMapping",method = {RequestMethod.GET},params = {"userName","age=18"},headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解的作用！！！");
        return "hello";
    }
}
