package com.jdbcTemplate.start;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate最基本的用法
 */
public class JdbcStart {
    public static void main(String[] args) {
        //准备数据源  spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://192.168.1.8:3306/qilvbin");
        ds.setUsername("root");
        ds.setPassword("Root@1314!");
        //创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //给jdbcTemplate设置数据源
        jdbcTemplate.setDataSource(ds);
        //执行操作
        jdbcTemplate.execute("insert into account_spring(uname,money) values('老李',7000)");
    }
}
