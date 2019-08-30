package day_05_ListSetMap.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {


        List als = new ArrayList();


        ArrayList ols = null;
        for (int i = 1; i < 10; i++) {

            ols = new ArrayList();
            for (int j = 1; j < i+1; j++) {
                int a = i * j;
                ols.add(j+"*"+i+"="+a);
            }
            als.add(ols);
        }



        for (int k = 0; k < als.size(); k++) {
            System.out.println(als.get(k));
        }


    }

}
