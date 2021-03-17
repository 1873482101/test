package cn.itcust.web.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo8")
public class requestDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("requestDemo8---");
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/requestDemo9");//获取转发对象
//        requestDispatcher.forward(request,response);//使对象进行转发
/*
* 注意
* forward（）只可以转发本服务器下的路径
* 浏览器地址栏路径不会跳转
* 转发是一次请求
* */    request.setAttribute("vlue","杨帆");//设置共享数据
        request.getRequestDispatcher("/requestDemo9").forward(request,response);//链式编程
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }
}
