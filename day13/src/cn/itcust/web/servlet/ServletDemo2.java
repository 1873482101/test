package cn.itcust.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/demo2")//注解方式替换xml配置
public class ServletDemo2 extends GenericServlet{

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("杨帆一定是憨憨");
    }
}
