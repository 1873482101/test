package cn.datasource.druid;

import cn.utils.JDBCUtilsl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) {
        String sql = "insert into user values(null,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //获取连接
             conn = JDBCUtilsl.getConnection();
             //获取pstmt对象
             pstmt = conn.prepareStatement(sql);
             //给？赋值
            pstmt.setString(1,"杨帆");
            pstmt.setString(2,"123456");
            //执行SQL
            int count = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            JDBCUtilsl.close(pstmt,conn);
        }

    }
}
