package com.transaction.anno.transferManagerAllAnno.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的配置类，相当于bean.xml
 */
@Configuration
@ComponentScan("com.transaction.anno.transferManagerAllAnno")//需要扫描的包
@Import({JdbcConfig.class,TransactionConfig.class})//导入数据库连接相关的配置类
@PropertySource("jdbc.properties")//指定数据库连接信息属性文件
@EnableTransactionManagement//开启事务注解的支持
public class SpringConfiguration {
}
