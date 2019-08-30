package bbs_demo.entity;

import java.io.Serializable;

public class Topic implements Serializable {

   private int tId;
   private String title;
   private String context;
   private String pTime;
   private User user;
   private Board board;

    public Topic() {
    }

    public Topic(int tId) {
        this.tId = tId;
    }

    public Topic(String title, String context, User user, Board board) {
        this.title = title;
        this.context = context;
        this.user = user;
        this.board = board;
    }

    public Topic(int tId, String title, String context, String pTime, User user, Board board) {
        this.tId = tId;
        this.title = title;
        this.context = context;
        this.pTime = pTime;
        this.user = user;
        this.board = board;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
