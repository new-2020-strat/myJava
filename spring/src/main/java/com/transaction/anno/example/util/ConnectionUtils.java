package com.transaction.anno.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@Component("connectionUtils")
public class ConnectionUtils {
    @Autowired
    private DataSource dataSource;
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadLocal(){
        //先从ThreadLocal上获取连接
        Connection connection = tl.get();
        //判断当前线程上是否有连接
        if(connection==null){//当前线程没有连接
            //从数据源中获取连接，并且和线程绑定(存入ThreadLocal中)
            try {
                connection = dataSource.getConnection();
                tl.set(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    /**
     * 将线程和连接解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
