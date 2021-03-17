package cn.itcast.jdbc;
import java.sql.*;


public class jdbcDemo6 {
    public static void main(String[] args) {
        String path = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        String sql1 = "select * from user ";

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName(path);
            //获取连接对象
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            //执行SQL
             rs = stmt.executeQuery(sql1);
            //处理结果
            while(rs.next()){//让游标向下移动一行
                //解析给定字段的值
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String passw = rs.getString("password");
                int role = rs.getInt("role");

                System.out.println(id+"--"+name+"--"+passw+"--"+role+"--");

            }





        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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
