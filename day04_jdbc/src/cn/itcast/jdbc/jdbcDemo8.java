package cn.itcast.jdbc;

import cn.itcast.domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class jdbcDemo8 {
    public static void main(String[] args) {
        List<Emp> list = new jdbcDemo8().findAll();
        System.out.println(list.toString());
    }

    public List<Emp> findAll(){
        String path = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db3?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        String sql1 = "select * from emp";

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        Emp emp = null;
        List<Emp> list = new ArrayList<Emp>();
        try {
            Class.forName(path);

             conn = DriverManager.getConnection(url, username, password);

             stmt = conn.createStatement();

             rs = stmt.executeQuery(sql1);

             while (rs.next()){
                 int id = rs.getInt("id");
                 String ename = rs.getString("ename");
                 int job_id = rs.getInt("job_id");
                 int mgr = rs.getInt("mgr");
                 Date joindate = rs.getDate("joindate");
                 double salary1 = rs.getDouble("salary");
                 double bounds = rs.getDouble("bonus");
                 int dept_id = rs.getInt("dept_id");

                 emp = new Emp();
                 emp.setId(id);
                 emp.setName(ename);
                 emp.setJob_id(job_id);
                 emp.setMgr(mgr);
                 emp.setJoindate(joindate);
                 emp.setSalary(salary1);
                 emp.setBonus(bounds);
                 emp.setDept_id(dept_id);


                 list.add(emp);
             }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
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
        return list;
    }
}
