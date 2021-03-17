package cn.jdbctemplate;

import cn.utils.JDBCUtilsl;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateDemo1 {
    public static void main(String[] args) {
        //创建jdbctemple 对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtilsl.getDataSource());
        //调用更新方法
        String sql = "update user set password = '1234' where id = ?";
        int count = template.update(sql,3);
        System.out.println(count);


    }
}
