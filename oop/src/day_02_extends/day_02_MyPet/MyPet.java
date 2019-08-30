package day_02_extends;

public class MyPet {
    private String name;
    private int age;
    private String color;

    MyPet() {

    }

    MyPet(String name, int age, String color) {
        this.age = age;
        this.name = name;
        this.color = color;
    }


    protected void playWithOwner() {
        System.out.println("我叫"+name+age+"岁"+color);
        System.out.println("我的主人是...");
    }
}
