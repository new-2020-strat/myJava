package com.notes.connectPool;

public class Pool {
    /**数据库连接池：减少连接数据库所用的时间(一个集合对象，且线程安全，队列特性(先进先出))
     *
     *  在主配置文件中的DataSource标签中的type属性指定连接池的方式
     *   type属性的三种取值：
     *      POOLED：采用传统的javax.sql.datasource规范中的连接，mybatis有针对该规范的实现，从池中获取
     *              如果有空闲的连接，就取用空闲，如果没有空闲就判断活动的连接池是否超过设定的连接数量
     *              如果没有超过，就再创建一个连接用，如果超过了就取用最老的连接(一些参数修改)用
     *      UNPOOLED：也采用的传统的连接方式，但是并没有使用池的思想，每次都会创建连接释放连接
     *      JNDI：采用服务器提供的JNDI技术，来获取DataSource对象，不同的服务器获取的DataSource对象是不一样的
     *               注意：不是web和maven工程的是不可以使用的
     *                      tomcat使用的是dbcp连接池
     *
     *
     *
     *
     *
     *
     */
}
