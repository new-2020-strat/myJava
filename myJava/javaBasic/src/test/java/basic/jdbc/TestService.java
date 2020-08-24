package basic.jdbc;


import module.jdbc.jdbcUtil.ConnectUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestService {
    @Test//测试查询员工表
    public void findUser(){
        Connection connection = ConnectUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //String sql = "select * from emp";
        String sql = "update EMP set COMM = 3000 where EMPNO='7369'";
        try {
            preparedStatement = connection.prepareStatement(sql);

            int num = preparedStatement.executeUpdate();

            connection.commit();
            System.out.println("num="+num);

            /*resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("ename"));
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectUtil.closeResultSet(resultSet);
            ConnectUtil.closeStatement(preparedStatement);
            ConnectUtil.closeConnection(connection);
        }

    }
}
