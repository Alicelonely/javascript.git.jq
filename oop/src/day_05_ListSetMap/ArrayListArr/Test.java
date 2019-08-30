package day_05_ListSetMap.ArrayListArr;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        Student stu1 = new Student("哪吒", 12, "火枪，控火术");
        Student stu2 = new Student("孙悟空", 12, "金箍棒,七十二变");
        Student stu3 = new Student("杨戬", 12, "三尖两刃刀，变身术");
        Student[] arr = new Student[3];

        arr[0] = stu1;
        arr[1] = stu2;
        arr[2] = stu3;
        List<Student> ls = new ArrayList();

        for (int i = 0; i < arr.length; i++) {

            ls.add(arr[i]);
        }

        for (int k = 0; k < ls.size(); k++) {
            Student s = ls.get(k);

            System.out.println("姓名:"+s.getName()+"\n年龄:"+s.getAge()+"\n武器技能"+s.getAttribute());

        }

    }

}
