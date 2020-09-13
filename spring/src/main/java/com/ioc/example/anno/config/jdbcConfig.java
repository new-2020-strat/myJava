package com.ioc.example.anno.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

//和spring连接数据库相关的
@Configuration
public class jdbcConfig {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUser;
    @Value("${jdbc.password}")
    private String jdbcPassword;
    /**创建QueryRunner对象并存入Spring容器* */
    @Bean
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){/**@qualifier可以指定具体的数据源，默认@autowried*/
        return new QueryRunner(dataSource);
    }
    /***创建数据源*/
    @Bean(name="dataSource")
    public ComboPooledDataSource createDataSource(){
        try {
            ComboPooledDataSource cs = new ComboPooledDataSource();
            cs.setDriverClass(jdbcDriver);
            cs.setJdbcUrl(jdbcUrl);
            cs.setUser(jdbcUser);
            cs.setPassword(jdbcPassword);
            return cs;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
