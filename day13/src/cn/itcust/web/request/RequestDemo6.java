package cn.itcust.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet( "/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置流的编码
        request.setCharacterEncoding("utf-8");
        //*****根据参数名称获取参数值
//        String parameter = request.getParameter("username");
//        String method = request.getMethod();
//        System.out.println(method);
//        if(method.contains("POST"))
//            System.out.println("post");
//        else if(method.contains("GET"))
//            System.out.println("get");
//


//        //根据参数名称获取参数值数组
//        String[] hobbies = request.getParameterValues("hobby");
//        for (String s:hobbies){
//            System.out.print(s+"&&");
//
//        }
//        System.out.println();


        //获取所有请求参数名称
//        Enumeration<String> parameterNames = request.getParameterNames();//获取所有键的名称
//        while (parameterNames.hasMoreElements()){
//            String s = parameterNames.nextElement();
//            System.out.println(s);
//
//            //String parameter2 = request.getParameter(s);
//            //System.out.println(parameter2);
//            String[] parameter1 = request.getParameterValues(s);
//            for (String s1:parameter1){
//            System.out.print(s1+"&&");
//
//        }
//            System.out.println("-------------");
//        }

        //*****获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> set = parameterMap.keySet();
        for (String name:set
             ) {
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String valu :values
            ) {
                System.out.println(valu);

            }
            System.out.println("--------");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
