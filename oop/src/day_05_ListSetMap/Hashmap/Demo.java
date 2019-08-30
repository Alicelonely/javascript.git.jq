package day_05_ListSetMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Student stu1 = new Student("张三",12);
        Student stu2 = new Student("李四",15);
        Student stu3 = new Student("翠花",17);

        Map<String,Student> map = new HashMap();

        map.put("1",stu1);
        map.put("2",stu2);
        map.put("3",stu3);


        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要查询的学生编号");

        String num = sc.next();

        if (map.containsKey(num)){
            System.out.println(map.get(num).getName()+","+map.get(num).getAge());
        }else {
            System.out.println("未找到学员编号对应的学员信息");
        }


    }

}
