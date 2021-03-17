package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo1 {
    /*1.导入驱动jar包 1）复制.jar包到项目的libs目录下 2）add as library
      2.注册驱动

     */

    /*
        注册驱动
        // String path = "com.mysql.jdbc.Driver";
        String path = "com.mysql.cj.jdbc.Driver";
            获取数据库连接对象
        // static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";

        DriverManager：驱动管理对象
        Connection：数据连接对象
        Statement：执行SQL的连接对象
        PreparedStatement：执行SQL的对象


     */
    public static void main(String[] args) throws Exception {
     // 2.注册驱动
        String path = "com.mysql.cj.jdbc.Driver";
        Class.forName(path);   // 传入驱动代码位置 com.mysql.jdbc.Driver类中的静态代码块执行java.sql.DriverManager.registerDiver(new Driver());
        //3.获取数据库连接对象

        String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
        String username = "root" ;
        String password = "123456" ;
        Connection conn = DriverManager.getConnection(URL, username, password);
        // 定义SQL语句
        String sql = "update user set role = 2 where role = 1";
        String sql1 = "insert into user values(3,'杨帆','123456',1)";
        //获取SQL对象
        Statement stmt = conn.createStatement();
        //执行SQL
        int count = stmt.executeUpdate(sql);//执行DML（insert，update，delete）和DDL（create，alter，drop）返回值为影响的行数
                                            //resultSetQuer(String sql):执行DQL(select)语句
        //处理结果
        System.out.println(count);
        //释放资源
        stmt.close();
        conn.close();



    }

}
