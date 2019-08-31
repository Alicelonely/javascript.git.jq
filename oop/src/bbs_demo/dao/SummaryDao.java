package bbs_demo.dao;

import bbs_demo.entity.Summary;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SummaryDao extends DBUtil {

    /**
     * 获取汇总数据
     * @return
     */
    public List<Summary> getAllTopic(){

        Connection conn = getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Summary> list = new ArrayList();
        String sql = "select t.tId,t.title,t.context,t.pTime,u.uName,b.bId,b.bName from topic t,User u,board b where t.uId = u.uId and t.bId = b.bId order by t.tId";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Summary summary = new Summary(rs.getInt("tId"),rs.getString("title"),rs.getString("context"),rs.getString("pTime"),rs.getString("uName"),rs.getInt("bId"),rs.getString("bName"));

                list.add(summary);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }


        return list;
    }

    /**
     * 最活跃用户
     * @return
     */
    public List<Summary> mostActive(){
        Connection conn = getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Summary> list = new ArrayList();
        String sql = "SELECT u.uName,COUNT(*) f from user u,topic t WHERE u.uId = t.uId GROUP BY u.uName ORDER BY f;";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Summary summary = new Summary(rs.getString("uName"),rs.getInt("f"));

                list.add(summary);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }


        return list;
    }

}
