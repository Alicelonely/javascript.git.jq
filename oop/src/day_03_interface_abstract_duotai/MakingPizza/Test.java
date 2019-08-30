package day_03_interface_abstract_duotai.MakingPizza;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        String attribute;

        int size;

        int price;
        Pizza p = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择您要制作的披萨：1.培根披萨  2.海鲜披萨");
        int a = scanner.nextInt();


        System.out.println("请输入配料信息");
        attribute = scanner.next();
        System.out.println("请输入披萨大小");
        size = scanner.nextInt();
        System.out.println("请输入披萨价格");
        price = scanner.nextInt();


        if (a == 2) {
            p = new Seafood(attribute, price, size);
        } else if (a == 1) {
            p = new Bacon(attribute, price, size);
        }
        
        p.show();

    }

}
