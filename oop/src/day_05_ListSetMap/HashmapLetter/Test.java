package day_05_ListSetMap.HashmapLetter;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请随意输入几个英文字母");

        String letter = sc.nextLine();

        char [] arr = letter.toCharArray();

        Map<Character, Integer> map = new HashMap();


        for (int i = 0; i < arr.length; i++) {
           if(map.containsKey(arr[i])){
                map.put(arr[i],(Integer)map.get(arr[i])+1);

           }else{
               map.put(arr[i], 1);
           }



        }
        Set set = map.keySet();
        Iterator it = set.iterator();

        while (it.hasNext()){
            char key = (char) it.next();
            int value = (int) map.get(key);
            System.out.println(key+":"+value);
        }





    }

}
