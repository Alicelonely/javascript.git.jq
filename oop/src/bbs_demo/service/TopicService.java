package bbs_demo.service;

import bbs_demo.dao.TopicDao;
import bbs_demo.dao.UserDao;
import bbs_demo.entity.Board;
import bbs_demo.entity.Topic;
import bbs_demo.entity.User;

import java.util.Scanner;

public class TopicService {

    TopicDao topicDao = new TopicDao();
    BoardService boardService = new BoardService();
    Scanner scanner = new Scanner(System.in);

    /**
     * 发帖
     */
    public void addTopic() {
        boardService.getAllBoard();
        System.out.println("请输入板块编号");
        int bId = scanner.nextInt();
        System.out.println("请输入主贴标题");
        String title = scanner.next();
        System.out.println("请输入主贴内容");
        String context = scanner.next();
        Board board =new Board(bId);
        User user = UserService.u;
        Topic topic =new Topic(title,context,user,board);
        boolean result = topicDao.addTopic(topic);
        if(result){
            System.out.println("发帖成功");
        }else{
            System.out.println("发帖失败");
        }
    }
}
