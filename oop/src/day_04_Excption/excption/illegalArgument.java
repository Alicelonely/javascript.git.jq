package day_04_Excption;

import java.text.SimpleDateFormat;
import java.util.Date;

public class illegalArgument {

    public static void main(String[] args) {

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dfdwafmm-dd");

        System.out.println(sdf.format(date));

    }

}
