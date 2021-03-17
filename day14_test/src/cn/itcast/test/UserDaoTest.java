package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

/**
 *@ClassName: UserDaoTest
 *@Description:
 *@Author 梁智
 *@Date 2020/11/19
 *@Version 1.0
 *
 */
public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("杨帆");
        loginuser.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);


    }

}
