package cn.itcast.util;

import cn.itcast.domain.Emp;
import cn.itcast.jdbc.jdbcDemo8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Utilstest {
    public static void main(String[] args) {
        //记得去更改jdbc.properties 的url中的数据库名称改为（db3）
        List<Emp> list = new jdbcDemo8().findAll();
        System.out.println(list.toString());
    }

    public List<Emp> findAll(){

        String sql1 = "select * from emp";
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        Emp emp = null;
        List<Emp> list = new ArrayList<Emp>();
        try {
            conn = JDBCUtils.getConnection();

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


        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
}
