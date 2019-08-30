package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
    static String driver;

    static String url;

    static String user;

    static String password;

    //读取文件中的数据库连接参数
    static {//给静态属性进行初始化，用来读取文件中配置数据
        //1.利用Properties类读取配置文件
        //2.从配置文件中查找想对象的参数信息

        try {
            Properties p = new Properties();
            InputStream i = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //通过load将流中的信息加载到properties对象中
            p.load(i);
            driver = p.getProperty("jdbc.driver");
            url = p.getProperty("jdbc.url");
            user = p.getProperty("jdbc.user");
            password = p.getProperty("jdbc.password");
        } catch (Exception e) {

        }


    }


    /**
     * 封装数据库连接过程，简化数据库的连接
     */
    public static Connection getConnection() {

        try {
            Class.forName(driver);
            Connection c = DriverManager.getConnection(url, user, password);
            return c;
        } catch (Exception e) {

            e.printStackTrace();
            //手动抛出异常
            throw new RuntimeException();
        }


    }


    public static  void  close(Connection c){
        if(c!=null){
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
