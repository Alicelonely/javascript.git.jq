package BBS.entity;

import BBS.dao.AdminDao;
import BBS.factory.MenuFactory;
import utils.DBUtil;

import java.util.Scanner;

public class Admin extends DBUtil implements AdminDao{

    Scanner scanner = new Scanner(System.in);


    /**
     * 用户管理
     */
    @Override
    public void userManage() {
        MenuFactory mf = new MenuFactory();
        System.out.println("1.权限修改 \t 2.查看用户");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                forbiddenUser();    //禁用用户
                break;
            case 2:
                seeUser();          //查看用户
                break;
        }






    }

    /**
     * 查看用户
     */
    private void seeUser() {
        MenuFactory mf = new MenuFactory();
        seeUserManage();
        mf.showAdminMenu_main();
    }

    /**
     * 查看用户信息
     */
    private void seeUserManage() {
        String sql = "select * from User";
        executeCHA(sql,null);
    }


    /**
     * 板块管理
     */
    @Override
    public void boardManage() {
        System.out.println("1.创建板块\t2.显示所有版块");
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                addBoard(); //创建板块
                break;
            case 2:
                 seeBoard();  //显示所有板块
                break;
        }

    }


    /**
     * 主贴管理
     */
    @Override
    public void postedManage() {
        MenuFactory mf = new MenuFactory();
        System.out.println("1.查看主贴\t2.删除主贴");
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                seeTopic();   //查看主贴
                break;
            case 2:
                seeTopic();
                delTopic();  //删除主贴
                break;
        }

        mf.showAdminMenu_main();


    }

    /**
     * 统计管理
     */
    @Override
    public void statistice() {
        MenuFactory mf = new MenuFactory();
        System.out.println("1.最活跃用户\t2.板块总帖数");
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                tmau();   //最活跃用户
                break;
            case 2:
                bkzts();  //板块总帖数
                break;
        }

        mf.showAdminMenu_main();

    }

    /**
     * 禁用用户
     */
    @Override
    public void forbiddenUser() {
        MenuFactory mf = new MenuFactory();
        User u =new User();
        seeUserManage();
        System.out.println("请输入要修改的用户编号");
        int uId = scanner.nextInt();
        System.out.println("请输入修改后的状态(0:代表正常,1:代表禁用)");
        int state = scanner.nextInt();

        String sql = "UPDATE User SET state = ? WHERE uId = ?";
        Object [] params={state,uId};
        int num = executeZSG(sql,params);
        if(num>0){
            System.out.println("禁止成功");
            mf.showAdminMenu_main();
        }else{
            System.out.println("禁止失败");
        }

    }

    /**
     * 查看板块
     */
    @Override
    public void seeBoard() {
        String sql = "select * from board";
        executeCHA(sql,null);
    }

    /**
     * 增加板块
     */
    @Override
    public void addBoard() {
        System.out.println("请输入新板块的名字");
        String bName =  scanner.next();
        String sql = "insert into board(bName) values(?)";
        Object [] params ={bName};
        executeZSG(sql,params);
    }

    @Override
    public void seeNomalUser() {

    }

    @Override
    public void seeforbiddenUser() {

    }

    @Override
    public void tmau() {
        System.out.println("用户姓名\t\t发帖数");
        String sql = "select u.uName,count(*) t from topic t,user u where u.uId = t.uId GROUP BY u.uName\n" +
                "ORDER BY t desc;";
        executeCHA(sql, null);
    }

    /**
     * 板块总贴数
     */
    @Override
    public void bkzts() {
        System.out.println("板块ID\t板块名字");
        String sql = "select * from board;";
        executeCHA(sql, null);
        System.out.println("输入想要统计的板块编号");
        int bId = scanner.nextInt();
        String sql1 = "select count(*) from topic where bId = ?;";
        Object [] params ={bId};
        executeCHA(sql1,params);
    }

    /**
     * 最活跃用户
     */
    @Override
    public void seeTopic() {

        String sql = "select t.tId,t.title,t.context,t.pTime,u.uName,b.bId,b.bName from topic t,User u,board b where t.uId = u.uId and t.bId = b.bId order by t.tId";
        executeCHA(sql, null);


    }

    /**
     * 删除主贴
     */
    @Override
    public void delTopic() {
        MenuFactory mf = new MenuFactory();
        System.out.println("请输入删除的主贴id");
        int tId = scanner.nextInt();

        String sql = "delete from topic where tId = ?";
        Object [] params ={tId};
        int num = executeZSG(sql,params);
        String sql1 = "delete from reply where tId = ?";
        Object [] params1 ={tId};
        int num1 = executeZSG(sql,params);

        if(num>0 || num1>0){
            System.out.println("删除成功");
            mf.showAdminMenu_main();
        }else{
            System.out.println("删除失败");
        }
    }



}
