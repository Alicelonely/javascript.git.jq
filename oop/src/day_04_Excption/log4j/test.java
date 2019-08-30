package day_04_Excption.log4j;


import org.apache.log4j.Logger;

public class test {


    public static void main(String[] args) {
        Logger logger = null;

        try {
            logger = Logger.getLogger(test.class.getName());
            logger.debug("开始运算");
            System.out.println(1 / 0);

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }



}
