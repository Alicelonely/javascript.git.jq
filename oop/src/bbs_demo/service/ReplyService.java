package bbs_demo.service;


import bbs_demo.dao.ReplyDao;
import bbs_demo.dao.UserDao;
import bbs_demo.entity.Reply;
import bbs_demo.entity.Topic;
import bbs_demo.entity.User;

import java.util.Scanner;

public class ReplyService {
    ReplyDao replyDao = new ReplyDao();

    SummaryService summaryService = new SummaryService();
    Scanner scanner = new Scanner(System.in);

    public void addReply() {
        summaryService.showSummary();
        System.out.println("请输入主贴编号");
        int tId = scanner.nextInt();
        System.out.println("请输入回帖标题");
        String title = scanner.next();
        System.out.println("请输入回帖内容");
        String context = scanner.next();
        User user = UserService.u;
        Topic topic =new Topic(tId);
        Reply reply = new Reply(title,context,user,topic);
        boolean result = replyDao.addReply(reply);
        if(result){
            System.out.println("回帖成功");
        }else{
            System.out.println("回帖失败");
        }
    }


}
