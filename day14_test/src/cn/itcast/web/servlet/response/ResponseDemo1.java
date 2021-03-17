package cn.itcast.web.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1.............");

       /* //访问//responseDemo1，会跳转到/responseDemo2资源
        //设置状态码302
        response.setStatus(302);
        //设置响应头location
        response.setHeader("location","/day14_test/responseDemo2");
        //重定向(redirect)的特点
            1、地址栏发生变化
            2、重定向可以访问其他站点（服务器）的资源
            3、重定向是两次请求,不能使用request对象进行数据共享

*/
        //简单的重定向方法
        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/responseDemo2");
       // response.sendRedirect("/day14_test/responseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
