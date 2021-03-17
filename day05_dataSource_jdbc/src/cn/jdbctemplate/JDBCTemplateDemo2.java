package cn.jdbctemplate;

import cn.domain.Emp;
import cn.utils.JDBCUtilsl;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTemplateDemo2 {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtilsl.getDataSource());
    @Test
    public void test1(){

        String sql = "update emp set salary = 10000 where id = 1001";
        int count = template.update(sql);
        System.out.println(count);
    }

    @Test
    public void test2(){

        String sql = "insert into emp(id,ename,dept_id) value (?,?,?)";
        int count = template.update(sql,1015,"憨憨",10);
        System.out.println(count);
    }

    @Test
    public void test3(){

        String sql = "delete from emp where id = ?";
        int count = template.update(sql,1015);
        System.out.println(count);
    }

    @Test
    public void test4(){
        //queryForMap查询的方法集长度只能是一
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);//{id=1001, ename=孙悟空, job_id=4, mgr=1004, joindate=2000-12-17, salary=10000.00, bonus=null, dept_id=20}
    }

    @Test
    public void test5(){
        //queryForList查询结果集合封装为list集合（每一条记录为map集合）
        String sql  = "select * from emp ";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap :list) {
            System.out.println(stringObjectMap);

        }
    }
    @Test
    public void test6(){
        //
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>(){
            @Override
            public Emp mapRow(ResultSet rs,int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp.setId(id);
                emp.setName(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                return emp;
            }
        });

        for (Emp emp :list){
            System.out.println(emp);
        }
    }

    @Test
    public void test6_2(){
        //query()查询结果将封装为BeanPropertyRowMapper实现类，完成时间到javaBean的自动封装
        //new BeanPropertyRowMapper<类型>(类型.class)
        String sql = "select * from emp;";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for(Emp emp : list){
            System.out.println(emp);
        }
    }
    @Test
    public void test7(){
        //queryForObject用于集合函数的延时
        String sql = "select count(id) from emp;";
        Long aLong = template.queryForObject(sql, long.class);
        System.out.println(aLong);
    }

}
