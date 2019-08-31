package bbs_demo.service;

import bbs_demo.dao.SummaryDao;
import bbs_demo.entity.Summary;

import java.util.List;
import java.util.Scanner;

public class SummaryService {

    SummaryDao summaryDao = new SummaryDao();
    Scanner scanner = new Scanner(System.in);
    BoardService boardService =new BoardService();
    /**
     * 展示汇总信息
     */
    public void showSummary() {
        List<Summary> ls = summaryDao.getAllTopic();
        for (Summary Summary : ls) {
            System.out.println(Summary.gettId() + "\t" + Summary.getTitle() + "\t" + Summary.getContext() + "\t" + Summary.getpTime()
                    + "\t" + Summary.getuName() + "\t" + Summary.getbId() + "\t" + Summary.getbName());
        }
    }

    /**
     * 汇总统计
     */
    public void preAccout() {
        System.out.println("1.最活跃用户\t2.板块总帖数");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                mostActive();
                break;
            case 2:
                boardService.totalBoard();
                break;


        }

    }


    /**
     * 最活跃的用户
     */
    private void mostActive() {
        List<Summary> ls = summaryDao.getAllTopic();
        System.out.println("姓名\t发帖数");
        for (Summary summary : ls) {

                System.out.println(summary.getuName()+"\t"+summary.getF());
            }

    }


}
