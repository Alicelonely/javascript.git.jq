package bbs_demo.dao;

import bbs_demo.entity.User;
import bbs_demo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends DBUtil {


    /**
     * 用户注册
     *
     * @return
     */
    public boolean userReg(User user) {


        String sql1 = "select uId from user where uName = ?";
        Object[] params1 = {user.getuName()};
        int result1 = executeCH(sql1, params1);
        if (result1 == 0) {
            String sql = "insert into user (uName,uPass,state,flag) values(?,?,0,0)";
            Object[] params = {user.getuName(), user.getuPass()};
            int result = executeZSG(sql, params);

            return result > 0 ? true : false;
        } else {
            System.out.println("已有该用户");
            return false;
        }
    }

    /**
     * 用户登录
     * @param uName
     * @param uPass
     * @return
     */
    public User userLogin(String uName, String uPass) {
        Connection conn = getConn();
        PreparedStatement ps = null;
        ResultSet rs =null;
        User user = null;
        String sql = "select * from user where uName = ? and uPass = ? and state = 0;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, uName);
            ps.setString(2, uPass);

            rs = ps.executeQuery();
            if(rs.next()){
                user = new User(rs.getInt("uId"),rs.getString("uName"),rs.getString("uPass"),rs.getInt("state"),rs.getInt("flag"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return user;
    }


    /**
     * 用户登录
     * @param uName
     * @param uPass
     * @return
     */
    public User adminLogin(String uName, String uPass) {
        Connection conn = getConn();
        PreparedStatement ps = null;
        ResultSet rs =null;
        User user = null;
        String sql = "select * from user where uName = ? and uPass = ? and state = 0 and flag = 1;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, uName);
            ps.setString(2, uPass);

            rs = ps.executeQuery();
            if(rs.next()){
                user = new User(rs.getInt("uId"),rs.getString("uName"),rs.getString("uPass"),rs.getInt("state"),rs.getInt("flag"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return user;
    }

    /**
     * 查看用户
     */
    public void viewUser(){
        String sql = "select * from user";
        executeCHA(sql,null);
    }

    /**
     *禁用用户
     */
    public boolean Prohibit(User user){
        String sql = "update user set state = ? where uId = ? and uName != ;";
        Object [] params={1,user.getuId()};
    }
}
