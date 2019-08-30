package day_03_interface_abstract_duotai.linkBox;

import javafx.print.PageOrientation;

public class Employee {

    public void makeBook(linkBox b,Paper p){
       Printer printer = new Printer();


        printer.print(b,p);
    }


    public static void main(String[] args) {
        linkBox b1 = new Block();
        linkBox b2 = new Color();

        Paper p1 = new A4paper();
        Paper p2 = new B5paper();

        Employee e = new Employee();

        e.makeBook(b1,p1);
        e.makeBook(b2,p2);
    }
}
