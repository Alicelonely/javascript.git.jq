package day_04_Excption;

import oracle.jdbc.aq.AQDequeueOptions;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {

    public static void main(String[] args) throws SQLException {
        //加载驱动
        Connection c = DBUtils.getConnection();
        //Statement：接口，调用方法实际返回的是实现类的对象，只不过使用接口来进行接收
        Statement st = c.createStatement();
        //定义sql语句创建一张表
        String sql = "create tables demo(id number(7),name varchar2(30))";
    }

}
