package cn.itcast.web.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* //设置response的编码
        response.setCharacterEncoding("gbk");
        //告诉浏览器，服务器发送的信息题数据的编码，建议浏览器使用该编码
        response.setHeader("content-type","text/html;charset=gbk");*/
        //可以指定浏览器解析页面时的编码，同时也内含 setCharacterEncoding的功能（用来简化setHeader）
        response.setContentType("text/html;charset=utf-8");
        //获取字符输出流
        PrintWriter pw = response.getWriter();
        //输出数据
        pw.write("<h1>ddd杨帆是憨憨ddd</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
