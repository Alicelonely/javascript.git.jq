package bbs_demo.dao;

import bbs_demo.entity.Board;
import bbs_demo.entity.Summary;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao extends DBUtil {

    /**
     * 查看所有板块
     */
    public List<Board> getAllBoard(){
        Connection conn = getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Board> list = new ArrayList();
        String sql = "select * from board";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
              Board board = new Board(rs.getInt("bId"),rs.getString("bName"));
              list.add(board);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }

        return list;
    }

    /**
     * 创建板块
     * @return
     */
    public boolean setBoard(String bName){
        String sql ="insert into board(bName) values(?)";
        Object[]params= {bName};
        int result = executeZSG(sql, params);
        return result > 0 ? true : false;
    }


    /**
     * 板块总贴书
     */
    public List<Summary> totalBoard(){
        Connection conn = getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Summary> list = new ArrayList();
        String sql = "SELECT b.bName,COUNT(*) f from board b,topic t WHERE b.bId = t.bId GROUP BY b.bName ORDER BY f;";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Summary summary = new Summary(rs.getString("bName"),rs.getInt("g"));

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
