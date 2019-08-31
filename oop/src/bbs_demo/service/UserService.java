package bbs_demo.service;

import bbs_demo.dao.UserDao;
import bbs_demo.entity.Board;
import bbs_demo.entity.User;
import bbs_demo.util.Demo;

import java.util.Scanner;

public class UserService {
    UserDao userDao = new UserDao();
    Scanner scanner = new Scanner(System.in);
    TopicService topicService = new TopicService();
    ReplyService replyService = new ReplyService();
    SummaryService summaryService = new SummaryService();

    public static User u = null;

    /**
     * 用户注册
     */
    public void userReg() {
        System.out.println("请输入昵称");
        String uName = scanner.next();
        System.out.println("请输入密码");
        String uPass = scanner.next();
        User user = new User(uName, uPass);
        boolean answer = userDao.userReg(user);
        if (answer) {
            System.out.println("注册成功");
        } else {
            System.out.println("注册失败");
        }


    }




    /**
     * 用户登录
     */
    public void userLogin() {
        Demo demo = new Demo();
        System.out.println("请输入昵称");
        String uName = scanner.next();
        System.out.println("请输入密码");
        String uPass = scanner.next();
        User user = userDao.userLogin(uName, uPass);
        if (user != null) {
            System.out.println("登录成功");
            u = user;
            System.out.println("欢迎登录\n" +
                    "1.发帖\t2.回帖\t3.返回请选择：\n");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    topicService.addTopic();
                    break;
                case 2:
                    replyService.addReply();
                    break;
                case 3:
                    demo.init();
                    break;
            }

        } else {
            System.out.println("登录失败，密码错误");
        }
    }


    /**
     * 管理员登录
     */
    public void adminLogin() {
        UserService userService = new UserService();
        BoardService boardService = new BoardService();
        Demo demo = new Demo();
        System.out.println("请输入昵称");
        String uName = scanner.next();
        System.out.println("请输入密码");
        String uPass = scanner.next();
        User user = userDao.adminLogin(uName, uPass);
        if (user != null) {
            System.out.println("登录成功");
            u = user;
            System.out.println("1.用户管理\t2.版块管理\t3.主贴管理\t4.统计汇总\t5.退出\n");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    userService.userManage();
                    break;
                case 2:
                    boardService.admBoard();
                    break;
                case 3:
                    topicService.admTopic();
                    break;
                case 4:
                    summaryService.preAccout();
                    break;
                case 5:
                    demo.init();
                    break;
            }

        } else {
            System.out.println("登录失败");
        }
    }


    /**
     * 用户管理
     */
    public void userManage() {
        System.out.println("1.权限修改 \t 2.查看用户\t3.删除用户\t4.退出");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                modJur();
                userManage();
                break;
            case 2:
                viewUser();
                userManage();
                break;
            case 3:
                userDao.viewUser();
                delUser();
                userManage();
                break;
            case 4:

                break;

        }


    }

    /**
     * 展示用户
     */
    public void viewUser() {
        System.out.println("用户id\t\t用户名\t\t用户密码\t\t用户状态\t\t用户级别");
        userDao.viewUser();
    }

    /**
     * 权限修改
     */
    public void modJur() {
        System.out.println("1.修改用户状态\t2.修改用户权限");
        int choice = scanner.nextInt();

        userDao.viewUser();
        switch (choice) {
            case 1:

                Prohibit();
                break;
            case 2:

                setAdmin();
                break;


        }
    }

    /**
     * 禁用用户
     */
    public void Prohibit() {
        System.out.println("请输入要修改的用户编号");
        int uId = scanner.nextInt();
        System.out.println("请输入修改后的状态(0:代表正常,1:代表禁用)");
        int state = scanner.nextInt();
        User user = new User();
        user.setuId(uId);
        user.setState(state);
        boolean result = userDao.Prohibit(user);
        if (result) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    /**
     * 设置管理员
     */
    public void setAdmin() {
        System.out.println("请输入要修改的用户编号");
        int uId = scanner.nextInt();
        System.out.println("请输入修改后的状态(0:代表正常用户,1:代表管理员)");
        int flag = scanner.nextInt();
        User user = new User(uId, flag);
        boolean result = userDao.setAdmin(user);
        if (result) {
            System.out.println("设置成功");
        } else {
            System.out.println("设置失败");
        }
    }

    /**
     * 删除用户
     */
    public void delUser() {
        System.out.println("请输入想要删除用户的id");
        int uId = scanner.nextInt();
        boolean result = userDao.delUser(uId);
            System.out.println("删除完毕");
    }



}
