package day_02_extends;

public class Cat extends MyPet {
    private String weight;

    Cat() {

    }

    Cat(String name, int age, String color, String weight) {
        super(name, age, color);
        this.weight = weight;
    }

    void checkMonths() {
        super.playWithOwner();
        System.out.println("猫" + weight + "斤，能抓老鼠");
    }

}
