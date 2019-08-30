package BBS.test;

import BBS.entity.User;
import BBS.factory.MenuFactory;
import utils.DBUtil;

public class test {

    public static void main(String[] args) {

        MenuFactory mf = new MenuFactory();
        mf.showAppMenu();
//        new User().reply();
    }
}
