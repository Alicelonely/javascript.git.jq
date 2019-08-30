package day_03_interface_abstract_duotai;

public class Master {

    public static void print(Pet p) {
        p.eat();
    }


    public static void main(String[] args) {
        Dog g = new Dog();
        Parrot p  = new Parrot();
        print(g);
        print(p);

    }

}
