package cn.itcust.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo9")
public class requestDemo9 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * 共享数据；
        * 域对象：一个有作用范围的对象，可以在范围内共享数据
        * request作用域代表一个请求的范围，一般用于请求转发多个资源中共享数据
        * 方法：set
        *       void setAttribute(String name,Objiece obj)存储数据
        *       object getAttribute(String name)通过键获取值
        *       void removeSttribute(String name) 通过键移除键值对
        * */
        Object vlue = request.getAttribute("vlue");//获取共享数据
        System.out.println(vlue+"就是憨憨");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
