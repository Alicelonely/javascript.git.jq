package day_01_jdbc;

import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedDemo {
    /**
     * 预编译的sql执行计划:提高执行计划
     *
     */

    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtils.getConnection();

        try{
            //  带参数的sql语句
            String sql = "insert into demo(id,name) values(?,?)";
            //先将sql语句发送给数据库，创建执行计划
            PreparedStatement ps = conn.prepareStatement(sql);
            //创建执行计划中的两个参数
            ps.setInt(1,5);
            ps.setString(2,"小黑");

            int n = ps.executeUpdate();
            System.out.println(n);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
    }
}
