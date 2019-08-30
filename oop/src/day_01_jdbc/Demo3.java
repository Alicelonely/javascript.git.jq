package day_01_jdbc;

import utils.DBUtils;

import java.sql.*;

public class Demo3 {
    public static void main(String[] args) throws Exception {


        Connection c = DBUtils.getConnection();

        try {
            //Statement：接口，调用方法实际返回的是实现类的对象，只不过使用接口来进行接收
            Statement st = c.createStatement();

            String sql = "select * from demo";
            //数据库查询到数据之后，java将结果封装到ResultSet对象中
            ResultSet rs = st.executeQuery(sql);
            //boolean next = rs.next();   //将标记移动到下一行，判断是否有数据


            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");
                System.out.println(name + "===" + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            DBUtils.close(c);
        }

    }
}
