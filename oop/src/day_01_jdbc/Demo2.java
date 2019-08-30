package day_01_jdbc;

import utils.DBUtils;

import java.sql.Connection;
import java.sql.Statement;

public class Demo2 {
    public static void main(String[] args) throws Exception {
        Connection c = DBUtils.getConnection();
        //Statement：接口，调用方法实际返回的是实现类的对象，只不过使用接口来进行接收
        Statement st = c.createStatement();
        //定义sql语句创建一张表
        String sql = "insert into demo(id,name) values(1,'小明')";
        //String sql = "update demo set name= '小红' where id=1";
        //String sql = "delete from demo where id = 1";
        int n = st.executeUpdate(sql);

        System.out.println(n);

        c.close();
    }
}
