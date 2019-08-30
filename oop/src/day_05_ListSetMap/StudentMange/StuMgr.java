package day_05_ListSetMap.StudentMange;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class StuMgr {

    private static List<Student> ls = new ArrayList();
    private static Scanner scanner = new Scanner(System.in);

    public static void addStu() {


        System.out.println("请输入学生的学号");
        int stuId = scanner.nextInt();
        System.out.println("请输入学生姓名");
        String stuName = scanner.next();
        System.out.println("请输入学生性别");
        String strSex = scanner.next();

        Student stu = new Student(stuId, stuName, strSex);
        ls.add(stu);

    }


    public static void checkStu() {


        System.out.println("请输入你要查询的学生姓名");
        String stuName = scanner.next();
        for (int i = 0; i < ls.size(); i++) {
            if(stuName.equals(ls.get(i).getName())){
                System.out.println(ls.get(i).getName()+"存在");
            }else {
                System.out.println(ls.get(i).getName()+"不存在");
            }
        }
    }


    public static void removeStu() {


        System.out.println("请输入你要删除的学生姓名");
        String stuName = scanner.next();
        for (int i = 0; i < ls.size(); i++) {
            if(stuName.equals(ls.get(i).getName())){
                ls.remove(ls.get(i));
                System.out.println("已删除");
            }else {
                System.out.println(ls.get(i).getName()+"不存在");
            }
        }
    }

    public static void showAll() {
        System.out.println("学号\t姓名\t性别");
        for (int i = 0; i < ls.size(); i++) {
            Student sd = ls.get(i);
            System.out.println(sd.getStudentId() + "\t" + sd.getName() + "\t" + sd.getSet());
        }
    }

}
