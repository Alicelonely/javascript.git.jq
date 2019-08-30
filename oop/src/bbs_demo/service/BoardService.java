package bbs_demo.service;

import bbs_demo.dao.BoardDao;
import bbs_demo.entity.Board;

import java.util.List;

public class BoardService {

    BoardDao boardDao = new BoardDao();
    /**
     * 显示模块
     */
    public void getAllBoard(){
        List<Board> ls =  boardDao.getAllBoard();
        System.out.println("板块编号\t板块名称");
        for (Board board:ls ) {
            System.out.println(board.getbId()+"\t"+board.getbName());
        }
    }
}
