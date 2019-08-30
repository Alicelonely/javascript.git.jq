package bbs_demo.dao;

import bbs_demo.entity.Board;
import bbs_demo.entity.Summary;
import bbs_demo.entity.Topic;
import bbs_demo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicDao extends DBUtil {

    /**
     * 发帖
     *
     * @return
     */
    public boolean addTopic(Topic topic) {
        String sql = "insert into topic(title,context,pTime,uId,bId) values(?,?,now(),?,?)";
        Object[] params = {topic.getTitle(), topic.getContext(), topic.getUser().getuId(), topic.getBoard().getbId()};
        int result = executeZSG(sql, params);
        return result > 0 ? true : false;

    }




}
