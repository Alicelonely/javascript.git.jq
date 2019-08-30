package bbs_demo.dao;

import bbs_demo.entity.Board;
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

}
