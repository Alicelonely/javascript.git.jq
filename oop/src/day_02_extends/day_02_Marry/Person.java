package day_02_extends;

public class Person {
    private String name;
    private int age;
    private boolean gender;
    private String partner;


    Person(String name, int age, boolean gender, String partner) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.partner = partner;
    }

    Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getParther() {
        return partner;
    }

    public void setParther(String parther) {
        this.partner = parther;
    }


    Boolean isMarry(Person p) {
        if (p.gender != this.gender) {
            System.out.println("可以结婚");
            return true;
        } else {
            System.out.println("不可以结婚");
            return false;
        }
    }
}
