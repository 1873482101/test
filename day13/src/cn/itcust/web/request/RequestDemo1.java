package cn.itcust.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求方式
        String method = request.getMethod();
        System.out.println(method);
        //获取虚拟目录
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //获取get方式请求参数naem = ***;
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //获取url
        String requestURI = request.getRequestURI();
        StringBuffer requestURI1 = request.getRequestURL();
        System.out.println("URI为："+requestURI+"   URL为："+requestURI1);
        //获取协议及版本
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //获取客户ip
        String localAddr = request.getLocalAddr();
        System.out.println(localAddr);
    }
}
