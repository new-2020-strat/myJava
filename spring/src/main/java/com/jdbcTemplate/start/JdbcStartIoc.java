package com.jdbcTemplate.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * JdbcTemplate最基本的用法
 */
public class JdbcStartIoc {
    public static void main(String[] args) {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("com\\jdbcTemplate\\start\\bean.xml");
        //获取对象
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //执行操作
        jdbcTemplate.execute("insert into account_spring(uname,money) values('小张',2000)");
    }
}
