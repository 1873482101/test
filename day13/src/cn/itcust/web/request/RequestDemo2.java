package cn.itcust.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       // 1.获取所有请求头名称
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()){
//            String s = headerNames.nextElement();
//            String header = request.getHeader(s);
//            System.out.println(s+"-------"+header);
//        }

        //contains  判断字符串中是否有子字符串
        //2.获取请求头 并判断浏览器类型
        String header = request.getHeader("user-agent");
        if(header.contains("Chrome")){
            System.out.println("谷歌来了");
        }else if(header.contains("Firecox")){
            System.out.println("火狐浏览器");

        }
        //获取数据头referer
        String referer = request.getHeader("referer");
        System.out.println(referer);
        if(referer!=null){
            if(referer.contains("/day13")){
                System.out.println("播放电影...");
                response.setContentType("text/html;charset=utf-8");//设置显示格式
                response.getWriter().write("播放电影");
            }
            else {
                System.out.println("请到优酷支持正版");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("请到优酷支持正版");
            }
        }

    }
}
