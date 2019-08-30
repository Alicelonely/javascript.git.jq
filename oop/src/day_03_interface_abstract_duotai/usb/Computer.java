package day_03_interface_abstract_duotai.usb;

public class Computer {

    public static void makeWork(Work k){
        System.out.println("电脑上是");
        k.work();
    }


    public static void main(String[] args) {
        Work k = new Mp3();

        makeWork(k);
    }
}
