package day_07_io.Copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Copy {

    public static void writeBytes() throws Exception {

        //file.sepatator的意思就是斜杠的意思,创建路径
        File file = new File("d:"+ File.separator +"test.txt");
        //创建对象用来读写问价，其中它的构造方法表示接受File类并设置r          r：表示只读，w：表示只写       rw：表示读写
        RandomAccessFile raf = null;
        raf = new RandomAccessFile(file,"rw");
        //声明空的变量，用来储存数据
        String name = null;
        int age = 0;
        name = "zhangsan";//字符串长度为8
        age = 30;//数字长度为4
        raf.writeBytes(name);//将姓名写入文件中
        raf.writeInt(age);//将年龄写入文件当中

        name = "lisi    ";
        age = 31;
        raf.writeBytes(name);
        raf.writeInt(age);

        name = "wangwu  ";
        age = 32;
        raf.writeBytes(name);
        raf.writeInt(age);

        raf.close();
    }

    /**
     * 读
     * @throws Exception
     */

    public static void readBytes() throws Exception {

        //file.sepatator的意思就是斜杠的意思,创建路径
        File file = new File("d:"+ File.separator +"test.txt");
        File file1 = new File("d:"+ File.separator +"test1.txt");
        //创建对象用来读写问价，其中它的构造方法表示接受File类并设置r          r：表示只读，w：表示只写       rw：表示读写
        RandomAccessFile raf = null;
        raf = new RandomAccessFile(file,"rw");
        RandomAccessFile raf1 = null;
        raf1 = new RandomAccessFile(file1,"rw");
        String name = null;
        int age = 0;
        byte[] b = new byte[8];

        //读取第二个人的信息
        raf.skipBytes(12);
        for (int i = 0; i < b.length; i++) {
            b[i] = raf.readByte();  //读取一个字节
        }

        name = new String(b);
        age = raf.readInt();
        raf1.writeBytes(name);
        raf1.writeInt(age);
        System.out.println("第二个人的信息是"+name+",年龄："+age);

        //读取第一个人的信息
        raf.seek(0);        //将光标设置到起始位置

        for (int i = 0; i < b.length; i++) {
            b[i] = raf.readByte();  //读取一个字节
        }

        name = new String(b);
        age = raf.readInt();
        raf1.writeBytes(name);
        raf1.writeInt(age);
        System.out.println("第一个人的信息是"+name+",年龄："+age);

        //读取第三个人的信息
        raf.skipBytes(12);        //将光标设置到起始位置

        for (int i = 0; i < b.length; i++) {
            b[i] = raf.readByte();  //读取一个字节
        }

        name = new String(b);
        age = raf.readInt();
        raf1.writeBytes(name);
        raf1.writeInt(age);
        System.out.println("第三个人的信息是"+name+",年龄："+age);




    }


    public static void main(String[] args) throws Exception {

        writeBytes();
        readBytes();
    }

}
