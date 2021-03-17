package cn.itcast.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        try {
            System.out.println("开始");
            //创建properties集合类
            Properties pro = new Properties();
            //加载文件
            //pro.load(new FileReader("D:/IDEA/itcast/day04_jdbc/src/jdbc.properties"));
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            System.out.println(path);
            pro.load(new FileReader(path));
            //获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("username");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            Class.forName(driver);
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * 获取连接对象
     * @return @return 连接对象
     * @throws SQLException
     */
    public static  Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }

    public static void close( Statement stmt, Connection conn){

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

    public  static void close(ResultSet rs, Statement stmt, Connection conn){
        if (rs != null) {
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
