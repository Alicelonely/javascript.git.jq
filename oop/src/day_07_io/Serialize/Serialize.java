package day_07_io.Serialize;


import java.io.*;

public class Serialize {

    public static void main(String[] args) throws Exception {

        //序列化
        FileOutputStream fos = new FileOutputStream("e:/stu.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Student stu = new Student("xiaoyan",12);
        oos.writeObject(stu);
        fos.close();
        oos.close();


        //反序列化
        FileInputStream fis = new FileInputStream("e:/stu.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student stu1 = (Student) ois.readObject();

        System.out.println(stu1.getName()+","+stu.getAge());
        fis.close();
        ois.close();
    }

}
