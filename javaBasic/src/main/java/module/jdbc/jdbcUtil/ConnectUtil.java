package module.jdbc.jdbcUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库连接工具，获取连接或关闭资源等
 */
public class ConnectUtil {
    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;

        //获取操作properties文件对象
        Properties properties = new Properties();
        //获取连接数据库信息的配置文件的输入流
        InputStream inputStream = ConnectUtil.class.getResourceAsStream("/basic/jdbc/jdbcUtil/jdbcConfig.properties");
        try {
            //加载流
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jdbc_driver = properties.getProperty("jdbc_driver");
        String jdbc_url = properties.getProperty("jdbc_url");
        String jdbc_username = properties.getProperty("jdbc_username");
        String jdbc_password = properties.getProperty("jdbc_password");

        try {
            //加载驱动类
            Class.forName(jdbc_driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //创建连接
            connection = DriverManager.getConnection(jdbc_url,jdbc_username,jdbc_password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭连接
     * @param connection
     */
    public static void closeConnection(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭通道
     * @param statement
     */
    public static void closeStatement(PreparedStatement statement){
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭结果集
     * @param resultSet
     */
    public static void closeResultSet(ResultSet resultSet){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
