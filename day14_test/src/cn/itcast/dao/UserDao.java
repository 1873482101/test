package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//操作数据库uer表


public class UserDao {
//声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * @description:
     * @param loginUser
     * @return: cn.itcast.domain.User
     * @author: 梁智
     * @time: 2020/11/19 10:21
     */
    public User login(User loginUser){
        User user = null;
    //编写sql
        String sql = "select * from user where username = ? and password = ?";
        //调用query方法
        try{
           user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
        } catch (EmptyResultDataAccessException e){
            return  null;
        }



        return user;
    }

}
