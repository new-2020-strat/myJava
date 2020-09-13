package com.start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*程序耦合案例
 * 耦合：程序中间的依赖关系
 *       包括：类之间的依赖
 *             方法之间的依赖
 *解耦：降低程序之间的依赖关系
 * 实际开发中：编译期不依赖，运行时才依赖
 * 解耦思路：1，尽量使用反射创建对象，不使用new关键字
 *           2，通过读取配置文件创建对象的全限定类名
 *
 * */
public class JdbcCouple {
    public static void main(String[] args) throws Exception {
        //注册驱动  如果没有相关的jar包是不能编译通过的
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //创建连接
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.8:3306/qilvbin","root","Root@1314!");
        //获取操作数据库的预处理对象
        PreparedStatement pst = con.prepareStatement("select * from user");
        //执行sql，得到结果集
        ResultSet rs = pst.executeQuery();
        //遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("username"));
        }
        //释放资源
        pst.close();
        con.close();
    }
}
