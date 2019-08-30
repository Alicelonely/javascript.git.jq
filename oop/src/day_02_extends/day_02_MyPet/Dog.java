package day_02_extends;

public class Dog extends MyPet {
    private String species;

    Dog() {

    }

    Dog(String name, int age, String color, String species) {
        super(name, age, color);
        this.species = species;
    }

    void lookDoor() {

        super.playWithOwner();
        System.out.println(species + "看门");
    }
}
