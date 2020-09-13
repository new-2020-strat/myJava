package com.ioc.example.anno.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
这个类的作用跟bean.xml一样
 Spring中的新注解:
 @Configuration
    作用：指定当前类是一个配置类
    细节：如果该配置类作为AnnotationConfigApplicationContext类参数传入时@Configuration注解可以不写
 @ComponetScan
     作用：用于通过注解指定Spring容器创建时要扫描的包
     属性：value，和basepackage一样，都是指定要扫描的包名
     相当于在bean.xml文件中配置了
     <context:component-scan base-package="com.iocAnno"></context:component-scan>
 @Bean
    作用：将方法的返回值作为bean对象存到spring容器中
    属性：name，指定bean对象的id，默认值为当前方法名称
    细节：当方法中有参数是spring会从spring容器中查找相应的bean对象
        和@Autowried是一样的
 @Import
    作用：用于导入其他的配置类
    属性：用于指定要入的配置类的字节码
            有@Import注解的类叫主配置类(父配置)，而导入的都是子配置类
 @propertySource
    作用：指定properties文件的位置
    属性：value，指定文件的名称和路径
                classpath表示类路径下
 */
@Configuration
@ComponentScan(value = {"com.ioc.example.anno"}) //value属于数组，若扫描多个包则{"包名1","包名2"}，只有一个包也可以省略value
@Import(jdbcConfig.class)
@PropertySource("com/ioc/example/anno/jdbcConfig.properties")
public class SpringConfiguration {

    /**
     * 导入子配置类jdbcConfig
     * */

    /**创建QueryRunner对象并存入Spring容器* */
    //@Bean
    //@Scope("prototype") //作用范围，多例或者单例
/*
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }
*/
    /***创建数据源*/
    //@Bean(name="dataSource")
    /*public ComboPooledDataSource createDataSource(){
        try {
            ComboPooledDataSource cs = new ComboPooledDataSource();
            cs.setDriverClass("com.mysql.jdbc.Driver");
            cs.setJdbcUrl("jdbc:mysql://192.168.206.128:3306/mydatabase");
            cs.setUser("root");
            cs.setPassword("root");
            return cs;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }*/
}
