package day_07_io.Character;

import java.io.*;

public class Character {

    public static void main(String[] args) throws Exception {

        File f =new File("e:"+File.separator+"demo.txt");
        Writer out = new FileWriter(f);

        out.write("你好，程序猿");
        out.close();

        Reader reader = new FileReader(f);
        char [] c = new char[1024];
        int len = reader.read(c);

        System.out.println(new String(c,0,len));
        out.close();
        reader.close();

    }

}
