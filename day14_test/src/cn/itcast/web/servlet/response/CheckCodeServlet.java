package cn.itcast.web.servlet.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int width = 100;
       int height = 50;
       //创建一对像，在内存中图片（验证码图片对象）
       BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
       //美化图片
        //填充背景
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0,width,height);

        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);

        String str = "ABCDEFGabcdefg01234456789";
        Random ran = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            graphics.drawString(ch+"",width/5*i,height/2);
        }

        //画干扰线
        graphics.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int y1 = ran.nextInt(width);
            int x2 = ran.nextInt(height);
            int y2 = ran.nextInt(height);

            graphics.drawLine(x1,y1,x2,y2);

        }


        //图片显示
        ImageIO.write(image,"jpg",response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
