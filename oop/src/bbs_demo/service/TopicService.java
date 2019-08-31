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
    SummaryService summaryService = new SummaryService();

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
        Board board = new Board(bId);
        User user = UserService.u;
        Topic topic = new Topic(title, context, user, board);
        boolean result = topicDao.addTopic(topic);
        if (result) {
            System.out.println("发帖成功");
        } else {
            System.out.println("发帖失败");
        }
    }


    /**
     * 主贴管理
     */
    public void admTopic() {
        System.out.println("1.查看主贴\t2.删除主贴");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:

                showTopic();
                break;
            case 2:

                delTopic();
                break;


        }
    }


    /**
     * 查看主贴
     */
    public void showTopic() {

        summaryService.showSummary();
    }

    /**
     * 删除主贴
     */
    public void delTopic() {
        showTopic();
        System.out.println("请输入删除的主贴id");
        int tId = scanner.nextInt();
        boolean result = topicDao.delTopic(tId);
        System.out.println("删除成功");
        topicDao.delTopic(tId);
    }

}
