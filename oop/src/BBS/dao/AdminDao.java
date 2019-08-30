package BBS.dao;

public interface AdminDao extends TopicDao,BoardDao,StatisticeDao,AdminUserDao{
    //用户管理
    void userManage();
    //板块管理
    void boardManage();
    //主贴管理
    void postedManage();
    //统计管理
    void statistice();

}
