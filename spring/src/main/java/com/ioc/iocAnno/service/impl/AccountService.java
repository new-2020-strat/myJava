package com.ioc.iocAnno.service.impl;

import com.ioc.iocAnno.dao.IAccountDao;
import com.ioc.iocAnno.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 模拟调用持久层
 *
 * 注解方式实现IOC：
 * 配置方式：
 * <bean id="accountService" class="com.ioc.iocCfg.service.impl.AccountService"
 *              scope="" init-method="" destroy-method="">
 *     <property name="" value=""| ref=""></property>
 * </bean>
 * 1.用于创建对象
 *      相当于在xml配置文件中配置<bean>
 *          Component:
 *              作用：相当于把当前类存入spring容器中
 *              属性：
 *                  value：指定bean的id，不写默认当前类名首字母小写
 *          衍生注解：作用一样，spring为了区分三层架构
 *                  Controller：用于表现层
 *                  Service：用于业务层
 *                  Repository：用于持久层
 * 2.用于注入数据
 *      相当于在xml配置文件中配置<property>
 *          1.Autowired:
 *              作用：自动按照类型注入,只要容器中有唯一的一个bean对象类型和要注入的类型匹配就可以诸如成功
 *              出现位置：变量和方法上
 *              细节：使用注解注入时，属性的set方法不是必须的
 *                    如果有多个匹配时，再从这多个匹配到的类型对象中进行变量名称进行匹配,如果在没有匹配到则报错
 *          2.Qualifier：
*                作用：在按照类中注入的基础上再按照名称注入,它在给类成员变量注入时不能单独使用,但在方法上可以
 *               属性：
 *                  value：用于指定注入bean的id
 *          3.Resource:
 *              作用：直接按照bean的id注入，可以独立使用
 *              属性
 *                  name:指定bean的id
 *      以上Autowired、Qualifier、Resource只能对其他bean类型的属性进行注入,而基本类型和String无法使用
 *      注意：集合类型的注入只能通过xml配置方式注入
 *          4.value：
 *              作用：用于注入基本类型和String类型变量的注入
 *              属性：
 *                  用于指定数据的值，他可以使用SpEl(spring的el表达式)
 *                  SpEl表达式：${表达式}
 * 3.用于改变作用域
 *      相当于在xml配置文件中<bean>标签中配置属性scope
 *      scope：
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值：常用取值(single、protoType)
 * 4.和声明周期相关(了解)
 *      相当于在xml配置文件中<bean>标签中配置属性init-method和destroy-method
*        PostConstruct
 *          作用：指定初始化方法
 *       PreDestroy
 *          作用：指定销毁方法
 */
//@Component("accountService")
//@Component(value = "accountService")
@Service(value = "accountService")
public class AccountService implements IAccountService {
    @Autowired
    @Qualifier
    public IAccountDao iAccountDao;
    public void saveAccount() {
        iAccountDao.saveAccount();
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化对象方法");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁对象方法");
    }
}
