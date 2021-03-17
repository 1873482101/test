package cn.itcast.web.Download;

import cn.itcast.util.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1获取请求参数
        String filename = request.getParameter("filename");
        System.out.println(filename);
        //2使用输入流加载文件进入内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        System.out.println(realPath);
        //2.2关联字节流
        FileInputStream fis = new FileInputStream(realPath);
        //3设置response的响应头
        //3.1设置响应头类型
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        //3.2设置响应头打开方式
        //解决中文文件名
        String agent = request.getHeader("user-agent");
        //使用工具类编码文件
        filename = DownLoadUtils.getFileName(agent, filename);
        response.setHeader("content-disposition","attachment;filenmame="+filename);

        //将输入流写出到输出流
        ServletOutputStream sos = response.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(bytes)) !=-1){
            sos.write(bytes,0,len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
