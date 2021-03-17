package cn.itcast.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Base64.Encoder;

/**
 * @ClassName: DownLoadUtils
 * @Description:
 * @Author 梁智
 * @Date 2020/11/22
 * @Version 1.0
 */
public class DownLoadUtils {
    public static String getFileName(String agent,String filename) throws UnsupportedEncodingException{
        if(agent.contains("MSIE")|| agent.contains("Trident")){
             filename = URLEncoder.encode(filename, "utf-8");
             filename = filename.replace("+"," ");

        }else if(agent.contains("Firefox")){
            Encoder encoder = Base64.getEncoder();
            filename = "=?utf-8?B?B" + encoder.encode(filename.getBytes("utf-8")) + "?=";
        }else {
             filename = URLEncoder.encode(filename, "utf-8");
        }


        return filename;
    }
}
