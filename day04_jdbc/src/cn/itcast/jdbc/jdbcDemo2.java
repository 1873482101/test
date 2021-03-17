package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo2 {
    public static void main(String[] args) {
        String path = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        String sql1 = "insert into user values(2,'杨帆','123456',1)";
        String sql2 = "update user set role = 2 where role = 1";
        String sql3 = " delete user where id = 2";

        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName(path);
             conn = DriverManager.getConnection(url, username, password);
             stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql1);
            System.out.println(count);
            if(count>0){
                System.out.println("添加/更新成功！");
            }else {
                System.out.println("添加/更新失败！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
