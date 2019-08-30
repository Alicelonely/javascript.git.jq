package day_05_ListSetMap.Hashset;

import java.util.*;
import java.util.spi.CurrencyNameProvider;

public class Test {

    public static void main(String[] args) {

        Commodity com1 = new Commodity(1,"猫粮",20);
        Commodity com2 = new Commodity(2,"罐头",30);
        Commodity com3 = new Commodity(3,"鸡胸肉",40);

        Set<Commodity> set  = new HashSet();

        set.add(com1);
        set.add(com2);
        set.add(com3);

        Iterator<Commodity> it =  set.iterator();

        List<Commodity> ls = new ArrayList<>();

        while(it.hasNext()){

            ls.add(it.next());

        }


        for (int i = 0; i < ls.size(); i++) {

            Commodity co =  ls.get(i);

            System.out.println(co.getId()+","+co.getName()+","+co.getPrice());
        }

    }

}
