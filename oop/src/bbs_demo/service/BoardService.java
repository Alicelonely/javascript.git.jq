package bbs_demo.service;

import bbs_demo.dao.BoardDao;
import bbs_demo.entity.Board;
import bbs_demo.entity.Summary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardService {

    BoardDao boardDao = new BoardDao();
    Scanner scanner = new Scanner(System.in);

    /**
     * 显示模块
     */
    public void getAllBoard() {
        List<Board> ls = boardDao.getAllBoard();
        System.out.println("板块编号\t板块名称");
        for (Board board : ls) {
            System.out.println(board.getbId() + "\t" + board.getbName());
        }
    }

    /**
     * 板块管理
     */
    public void admBoard() {
        System.out.println("1.创建板块\t2.显示所有板块");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                getAllBoard();
                setBoard();
                break;
            case 2:

                getAllBoard();
                break;


        }
    }

    /**
     * 创建板块
     */
    public void setBoard() {
        System.out.println("请输入新版块的名字");
        String bName = scanner.next();

        boolean result = boardDao.setBoard(bName);
        if (result) {
            System.out.println("设置成功");
        } else {
            System.out.println("设置失败");
        }
    }

    /**
     * 板块总贴数
     */
    public void totalBoard() {

        List<Summary> ls = boardDao.totalBoard();
        System.out.println("板块名\t发帖数");
        for (Summary summary : ls) {

            System.out.println(summary.getuName()+"\t"+summary.getF());
        }
    }
}
