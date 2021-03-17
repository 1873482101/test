package cn.itcast.web.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: LoginServlet
 * @Description:
 * @Author 梁智
 * @Date 2020/11/19
 * @Version 1.0
 */



@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
       /* //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);

        //封装user对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/

        //获取所有请求参数
        Map<String, String[]> map = req.getParameterMap();
        /*
        //打印map
        Set<String> set2 = map.keySet();
        for (String key : set2) {
            String[] value = map.get(key);
            for (String s:value)
                 System.out.print(key+"--"+s);
            System.out.println();
        }
        System.out.println("---------------------");*/
        //创建User对象
        User loginUser = new User();
        //使用BeanUtil封装
        try {
            BeanUtils.populate(loginUser,map);//使用apache.commons下的BeanUtils
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //调用UserDao的login方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        //进行资源转发
        /**
         * 资源转发（forward）的特点：
         *  转发地址栏路径不变
         *  转发只能访问当前服务器下的资源
         *  转发是一次请求，可以用qequest对象共享数据
         */
        if(user == null){
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }
        else {
            //设置存储数据
            req.setAttribute("user",user);
            //转发
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
