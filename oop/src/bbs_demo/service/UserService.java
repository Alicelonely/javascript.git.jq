package bbs_demo.service;

import bbs_demo.dao.UserDao;
import bbs_demo.entity.User;
import bbs_demo.util.Demo;

import java.util.Scanner;

public class UserService {
    UserDao userDao = new UserDao();
    Scanner scanner = new Scanner(System.in);
    TopicService topicService = new TopicService();
    ReplyService replyService = new ReplyService();

    static User u = null;
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
            System.out.println("登录失败");
        }
    }



    /**
     * 管理员登录
     */
    public void adminLogin() {
        UserService userService = new UserService();
        Demo demo = new Demo();
        System.out.println("请输入昵称");
        String uName = scanner.next();
        System.out.println("请输入密码");
        String uPass = scanner.next();
        User user = userDao.adminLogin(uName, uPass);
        if (user != null) {
            System.out.println("登录成功");
            u = user;
            System.out.println("1.用户管理\t2.版块管理\t3.主贴管理\t4.统计汇总\t5.新增管理员\t6.退出\n");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    userService.userManage();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
            }

        } else {
            System.out.println("登录失败");
        }
    }


    public void userManage(){
        System.out.println("1.权限修改 \t 2.查看用户\t3.删除用户");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                modJur();
                break;
            case 2:
                viewUser();
                break;
            case 3:
                delUser();
                break;

        }
    }

    public void viewUser(){
        System.out.println("用户id\t\t用户名\t\t用户密码\t\t用户状态\t\t用户级别");
        userDao.viewUser();
    }

    /**
     * 权限修改
     */
    public void modJur(){
        System.out.println("1.禁用用户\t2.设置管理员");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                userDao.viewUser();
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
    public void Prohibit(){
        System.out.println("请输入要修改的用户编号");
        int uId = scanner.nextInt();
        System.out.println("请输入修改后的状态(0:代表正常,1:代表禁用)");
        int state = scanner.nextInt();
        User user = new User(uId,state,);
        userDao.Prohibit(user);
    }

    /**
     * 设置管理员
     */
    public void setAdmin(){

    }

    /**
     * 删除用户
     */
    public void delUser(){

    }

}
