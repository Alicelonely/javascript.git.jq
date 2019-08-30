package day_04_Excption;

public class idxOutOfBounds extends NullPointer{

    public static void main(String[] args) {

        int [] arr = new int[4];

        System.out.println(arr[4]);

    }

}
