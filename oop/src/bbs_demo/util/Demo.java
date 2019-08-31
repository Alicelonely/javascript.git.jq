package bbs_demo.util;

import bbs_demo.service.UserService;

import java.util.Scanner;

public class Demo {


    Scanner sc = new Scanner(System.in);
    UserService userSevice = new UserService();


    public void init() {
        System.out.println("==============欢迎使用校园BBS================");
        System.out.println("请选择：1.管理员登陆\t2.用户登陆\t3.用户注册\t4.退出 ");
        int answer = sc.nextInt();


        switch (answer) {
            case 1:
                userSevice.adminLogin();
                break;
            case 2:
                userSevice.userLogin();
                break;
            case 3:
                userSevice.userReg();
                init();
                break;
            case 4:
                System.out.println("祝你生活愉快");
                break;


        }


    }


    public static void main(String[] args) {
        new Demo().init();
    }

}
