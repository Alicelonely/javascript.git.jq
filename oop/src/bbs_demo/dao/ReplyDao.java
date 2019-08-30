package bbs_demo.dao;

import bbs_demo.entity.Reply;
import bbs_demo.entity.Topic;
import utils.DBUtil;


public class ReplyDao extends DBUtil {


    /**
     * 发帖
     *
     * @return
     */
    public boolean addReply(Reply reply) {
        String sql = "insert into reply(title,context,pTime,uId,tId) values(?,?,now(),?,?)";
        Object[] params = {reply.getTitle(), reply.getContext(), reply.getUser().getuId(), reply.getTopic().gettId()};
        int result = executeZSG(sql, params);
        return result > 0 ? true : false;

    }

}
