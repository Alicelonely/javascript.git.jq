package day_07_io.BufferBytesCopy;

import java.io.*;

public class CopyByte {

    public static void Copy(String a,String b) {
        try {
            FileInputStream in = new FileInputStream(a);
            FileOutputStream os = new FileOutputStream(b);
            BufferedInputStream buffin = new BufferedInputStream(in);
            BufferedOutputStream bufof = new BufferedOutputStream(os);
            int count = 0;      //每次读取到的字节的长度
            byte [] date = new byte[1024];  //读取的单位


            while ((count = buffin.read(date)) != -1){
                bufof.write(date,0,count);
            }

            bufof.flush();
            buffin.close();
            buffin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {

        Copy("d:/hell.txt","d:/hell1.txt");

    }

}
