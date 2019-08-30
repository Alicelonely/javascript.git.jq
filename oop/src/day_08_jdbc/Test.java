package day_08_jdbc;

import utils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test extends DBUtil {


    static Scanner sc = new Scanner(System.in);
    static Connection conn = getConn();
    ;
    static Statement st = null;
    static ResultSet rs = null;


    public static void main(String[] args) {

        main();


    }

    public static void main() {
        System.out.println("请选择：1.查看新闻\t2.增加新闻\t3.删除新闻\t4.修改新闻");

        int choise = sc.nextInt();

        switch (choise) {
            case 1:
                seeNews();
                break;
            case 2:
                addNews();
                break;
            case 3:
                delNews();
                break;
            case 4:
                modifyNews();
                break;
        }
    }

    /**
     * 增加新闻
     */
    public static void addNews() {
        System.out.println("请输入新闻标题");
        String title = sc.next();
        System.out.println("请输入发布者");
        String creator = sc.next();
        System.out.println("请输入新闻内容");
        String conten = sc.next();

        StringBuffer sbsql = new StringBuffer("insert into t_news(TitleName,Creator,CreateTime,conten) values('");
        sbsql.append(title + "',");
        sbsql.append("'" + creator + "',");
        sbsql.append("now()" + ",");
        sbsql.append("'" + conten + "');");
        System.out.println(sbsql.toString());
        try {
            st = conn.createStatement();
            int result = st.executeUpdate(sbsql.toString());
            if (result > 0) {
                System.out.println("添加成功成功");
                main();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, st);
        }

    }


    public static void seeNews() {
        System.out.println("新闻编号\t新闻题目\t发布者\t发布时间\t内容\t");

        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from t_news");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("TitleName") + "\t" + rs.getString("Creator") + "\t" + rs.getString("CreateTime") + "\t" + rs.getString("conten"));
            }
            main();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, st, rs);
        }

    }

    public static void delNews() {
        System.out.println("请输入要删除的编号");
        int numNews = sc.nextInt();
        try {
            st = conn.createStatement();
            int result = st.executeUpdate("delete from t_news where id = '" + numNews + "'");
            if (result > 0) {
                System.out.println("删除成功");
            }
            main();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, st);
        }

    }

    public static void modifyNews() {
        System.out.println("请输入你要修改的标题的id");
        int num = sc.nextInt();
        System.out.println("请输入你要修改的标题");
        String title = sc.next();
        System.out.println("请输入你要修改的内容");
        String conten = sc.next();
        try {
            st = conn.createStatement();
            int result = st.executeUpdate("update t_news set TitleName='" + title + "',conten='" + conten + "'   where id = '" + num + "'");
            if (result > 0) {
                System.out.println("修改成功");
            }
            main();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, st);
        }

    }
}
