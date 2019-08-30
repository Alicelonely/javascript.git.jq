package day_07_io.BytesCopy;



import java.io.*;

public class Copy {

    public static void main(String[] args) throws Exception {

        File f = new File("d:"+File.separator+"hello.txt");
        File f1 = new File("d:"+File.separator+"hello1.txt");
        //用字节流读写
        OutputStream os = new FileOutputStream(f,true);
        OutputStream os1 = new FileOutputStream(f1,true);
        String str = "hello world";
        os.write(str.getBytes());
        os.close();

        InputStream in = new FileInputStream(f);

        byte [] buf = new byte[1024];
        int len = in.read(buf);
        System.out.println(new String(buf,0,len));
        os1.write(buf);
        in.close();
    }

}
