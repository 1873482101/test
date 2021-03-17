package cn.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
/*
注意<?xml version="1.0" encoding="UTF-8"?>放在第一行前面不能用空格或其他语句
测试时超时时间尽量大
 */
public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        System.out.println("---开始连接---");
        //创建数据库连接池对象 获取DataSource使用默认配置
        //DataSource ds = new ComboPooledDataSource();

        //获取DataSource使用指定名称配置
        DataSource ds = new ComboPooledDataSource("mySource");
        for (int i = 0; i < 14; i++) {
            //获取连接
            Connection conn = ds.getConnection();

            System.out.println(i+":"+conn);
            if(i==5)
                conn.close();//归还连接
        }

    }


}
