package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;
/**
 String sql = "select * from user where username = '"+username+"' and password = '"+password+ "'";
 1存在SQL注入的问题：在拼接SQL时，有一些SQL的特殊关键字参与字符串的拼接，会造成安全性问题
 当userna随便输入 password为 a' or 'a' = 'a
 SQL = select * from user where username = 'xsde' and password = 'a' or 'a' = 'a'
 2解决发法： 使用preparedStatement对象解决
 3：预编译的SQL：参数使用？作为占位符
 4：步骤：
 1.导入jar包mysql-connector-java-8.0.20-bin.jar(找自己对应版本的Jar)
 2.注册驱动
 3.获取数据库连接对象connection
 4.定义sql：
 *注意：SQL的参数使用？作为占位符。如： select *from user where username = ? and password = ?;
 5.获取执行SQL语句的对象 PreparedStatement Connection.PrepareStatement(String sql)
 6.给？赋值：
 *方法：setXXX(参数1，参数2)
 *参数1：？的位置编号从1开始
 *参数2：？的值
 7.执行sql,接收返回结果，不需要传递SQL语句
 8.处理结果
 9.释放资源

 */


public class jdbcDemo9 {

    public static void main(String[] args) {
        //记得更改jdbc.properties中的url 为db3
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入入户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        boolean flag = new jdbcDemo9().login2(username,password);

        if(flag){
            System.out.println("登录成功！");
        }else {
            System.out.println("用户名或者密码错误");
        }


    }


    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username,String password){
       if(username == null || password == null){
            return false;
        }
        Connection conn =null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select * from user where username = '"+username+"' and password = '"+password+ "'";

        System.out.println("开始---");
        System.out.println(sql);

        try {
            conn = JDBCUtils.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return  rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return false;
    }

    /**
     * 解决SQL注入和事务管理
     * @param username
     * @param password
     * @return
     */
    public boolean login2(String username,String password){
        if(username == null || password == null){
            return false;
        }
        Connection conn =null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from user where username = ? and password = ?";
        


        System.out.println("开始---");
        System.out.println(sql);

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);//开启事务管理

           // stmt = conn.createStatement();
            //rs = pstmt.executeQuery(sql);
            //修改为如下两句
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);

            rs = pstmt.executeQuery();
            //提交事务
            conn.commit();
            return  rs.next();

        } catch (SQLException e) {
            try {
                //回滚
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return false;
    }

}
