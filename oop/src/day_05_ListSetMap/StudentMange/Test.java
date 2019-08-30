package day_05_ListSetMap.StudentMange;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Boolean b;

        Scanner sc = new Scanner(System.in);

        Student stu1 = new Student(1, "哪吒", "男");

        Student stu2 = new Student(2, "杨戬", "男");

        Student stu3 = new Student(3, "孙悟空", "男");


        do {
            System.out.println("----------------欢迎使用学生管理系统-----------------\n" +
                    "请选择1.添加学生\t2.查询学生\t3.删除学生");
            int choise = sc.nextInt();
            switch (choise) {
                case 1:
                    StuMgr.addStu();
                    break;
                case 2:
                    StuMgr.checkStu();
                    break;
                case 3:
                    StuMgr.removeStu();
                    break;
            }


            System.out.println("是否要继续(y/n)?");


            if (sc.next().equals("n")) {
                b = false;
                StuMgr.showAll();
            } else {


                b = true;

            }

        } while (b);


    }

}
