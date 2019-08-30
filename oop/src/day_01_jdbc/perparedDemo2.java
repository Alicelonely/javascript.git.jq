package day_01_jdbc;

import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class perparedDemo2 {

    public static void main(String[] args) {
        test();
    }


    public static void test(){
        Connection conn = DBUtils.getConnection();

        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入你要查询的名字");
            String name = scanner.next();

            //当用户输入了含有sql成分的参数时，参数会发生语义的转变，这种情况叫做sql注入
            /**
             * 如何避免
             *  1.拦截用户输入的sql成分的参数时
             *  2.固定执行计划，避免改变执行逻辑
             */

//            //  带参数的sql语句
//            String sql = "insert into demo(id,name) values(?,?)";
//            //先将sql语句发送给数据库，创建执行计划
//            PreparedStatement ps = conn.prepareStatement(sql);
//            //创建执行计划中的两个参数
//            ps.setInt(1,5);
//            ps.setString(2,"小黑");
//
//            int n = ps.executeUpdate();
//            System.out.println(n);


            //先把sql发送到数据库当中
            String sql = "select * from demo where name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                System.out.println(name1 + "===" + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }

    }
}
