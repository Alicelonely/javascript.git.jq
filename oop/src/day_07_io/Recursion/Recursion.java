package day_07_io;

import java.io.File;

public class Recursion {

    public static void Recursoions(String path) {

        File f = new File(path);

        //如果是文件或者不存在，就返回
        if (!f.isDirectory() || !f.exists()) return;

        //否则就开始遍历
        File[] files = f.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.println(files[i].getName()+"\t文件大小"+files[i].length());
            }else{

                System.out.println(files[i].getName()+"<dir>\n");
                Recursoions(files[i].getPath());
                
            }
        }


    }


    public static void main(String[] args) {

        Recursoions("d:");

    }
}
