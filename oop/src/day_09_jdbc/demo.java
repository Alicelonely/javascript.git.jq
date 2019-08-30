package day_09_jdbc;

import utils.DBUtil;

public class demo extends DBUtil {

    public static void main(String[] args) {

        String sql = "select * from t_news where id = 2";
        Object[] params={"Alicelonely","上海大妈"};
        executeCHA(sql,null);

    }


}
