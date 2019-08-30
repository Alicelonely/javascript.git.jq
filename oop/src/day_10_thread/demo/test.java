package day_10_thread;

public class test {

    public static void main(String[] args) {

      demo2 [] de= new demo2[4];


        for (int i = 0; i < 4; i++) {
            de[i] = new demo2(i%2 ==0?true:false);
            de[i].start();
        }


    }

}
