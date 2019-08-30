package BBS.entity;

import BBS.dao.UserDao;
import BBS.factory.DBUtil;
import BBS.factory.MenuFactory;

import java.util.Scanner;


public class User extends DBUtil implements UserDao {


    MenuFactory mf = new MenuFactory();
    static String uName;

    /**
     * 登录
     */
    @Override
    public void register() {
        Scanner scanner = new Scanner(System.in);
        boolean flag;
        boolean flag1;
        do {
            System.out.println("请输入昵称");
            String name = scanner.next();
            uName = name;
            System.out.println("请输入密码");
            String pas = scanner.next();
            String sql = "select * from User where uName = ? and uPass = ?";
            Object[] params = {name, pas};
            flag = checkShowLoginMenu(sql, params);
            flag1 = getState();

            if (flag && flag1) {
                flag = false;
                flag1 = false;
                System.out.println("欢迎登录");
                mf.showUserMenu_do();
            } else {
                flag = true;
                flag1 = true;
                System.out.println("昵称或密码输入不正确或身份不符和或者您被禁用了");
                mf.showAppMenu();
            }
        } while (flag && flag1);
    }

    /**
     * 注册
     */
    @Override
    public void registeral() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入昵称");
        String name = scanner.next();
        System.out.println("请输入密码");
        String pas = scanner.next();
        String sql = "INSERT INTO User(uName,uPass,state,flag) VALUES (?, ?, 0, 1)";
        Object[] params = {name, pas};
        int num = executeZSG(sql, params);
        if (num > 0) {
            System.out.println("注册成功");
            mf.showAppMenu();
        } else {
            System.out.println("发帖失败");
        }
    }


    /**
     * 发帖
     */
    @Override
    public void posted() {
        Scanner scanner = new Scanner(System.in);
        String sql = "select * from board";
        executeCHA(sql, null);
        System.out.println("请输入板块编号");
        int bId = scanner.nextInt();
        System.out.println("请输入主贴标题");
        String title = scanner.next();
        System.out.println("请输入主贴内容");
        String context = scanner.next();
        int uId = getUid();
        System.out.println(uId);
        String sql1 = "INSERT INTO topic(title,context,pTime,uId,bId) VALUES (?,?,now(), ?,?)";
        Object[] params = {title, context, uId, bId};//uId
        int num = executeZSG(sql1, params);
        if (num > 0) {
            System.out.println("发帖成功");
            mf.showUserMenu_do();
        } else {
            System.out.println("发帖失败");
        }
    }

    /**
     * 获取用户状态
     *
     * @return
     */
    public boolean getState() {
        int state = 0;
        String sql1 = "select state from User where uName = ?";
        Object[] params = {uName};
        state = executeCH(sql1, params);
        return state == 0 ? true : false;
    }

    /**
     * 获取uId的值
     *
     * @return
     */
    public int getUid() {
        int uId = 0;
        String sql1 = "select uId from User where uName = ?";
        Object[] params = {uName};
        uId = executeCH(sql1, params);
        return uId;
    }


    /**
     * 回帖
     */
    @Override
    public void reply() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("主键ID\t\t主帖标题\t\t主贴内容\t\t发帖时间\t\t发帖人\t\t所属板块编号\t\t所属板块名称");
        String sql = "select t.tId,t.title,t.context,t.pTime,u.uName,b.bId,b.bName from topic t,User u,board b where t.uId = u.uId and t.bId = b.bId order by t.tId";
        executeCHA(sql, null);


        System.out.println("请输入主贴编号");
        int tId = scanner.nextInt();
        System.out.println("请输入回帖标题");
        String title = scanner.next();
        System.out.println("请输入回帖内容");
        String context = scanner.next();


        int uId = getUid();
        String sql2 = "INSERT INTO reply(title,context,pTime,uId,tId) VALUES (?,?, now(), ?,?)";
        Object[] params1 = {title, context, uId, tId};
        int num = executeZSG(sql2, params1);
        if (num > 0) {
            System.out.println("回帖成功");
            mf.showUserMenu_do();
        } else {
            System.out.println("回帖失败");
        }
    }
}
