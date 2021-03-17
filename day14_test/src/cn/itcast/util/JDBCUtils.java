package cn.itcast.util;/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/11/19 10:38<br/>
 *
 * @author 18734<br />
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *@ClassName: JDBCUtils
 *@Description: 工具包使用Druid连接池
 *@Author 18734
 *@Date 2020/11/19
 *@Version 1.0
 *
 */
public class JDBCUtils {
    private static DataSource ds;
    static {

        try {
            //加载配置文件
            Properties pro = new Properties();
            //使用ClassLoader加载配置文件获取字节输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            ///初始化连接对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 获取连接connection对象
     */
    public static Connection getConnerction() throws SQLException{
        return ds.getConnection();
    }

}
