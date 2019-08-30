package BBS.factory;

import BBS.entity.User;
import BBS.entity.Admin;

import java.util.Scanner;

public class MenuFactory {

    /**
     * 由于本项目是控制台程序，需要很多导航菜单。为了使导航菜单便于管理和编写，
     * 我们把这些导航菜单放到一个工厂类MenuFactory中，把这个类放在yunhe.factory包中。
     */


    Admin ad = new Admin();


    //程序主菜单
    public void showAppMenu() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------欢迎访问学校论坛-----------\n" +
                "\n" +
                "1.管理员登录\t2.普通用户登录\t3.注册\t4.退出\n" +
                "请选择：");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("请输入昵称");
                String name = scanner.next();
                System.out.println("请输入密码");
                String pasd = scanner.next();
                if (name.equals("Admin") && pasd.equals("Admin")) {
                    showAdminMenu_main();
                }

                break;
            case 2:
                user.register();
                break;
            case 3:
                user.registeral();
                break;
            case 4:
                System.out.println("祝您生活愉快");
                break;
        }

    }

    //管理员主菜单
    public void showAdminMenu_main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.用户管理\t2.版块管理\t3.主贴管理\t4.统计汇总\t5.退出\n" +
                "请选择：");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                ad.userManage();
                break;
            case 2:
                ad.boardManage();
                showAdminMenu_main();
                break;
            case 3:
                ad.postedManage();
                break;
            case 4:
                ad.statistice();
                break;
            case 5:
                showAppMenu();
                break;
        }


    }

    //普通用户主菜单
    public void showUserMenu_do() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.发帖\t2.回帖\t3.返回" +
                "请选择：");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                user.posted();
                break;
            case 2:
                user.reply();
                break;
            case 3:
                showAppMenu();
                break;
        }

    }



    //登录
    public void showLoginMenu() {
        User user = new User();
        user.register();
    }


}
