package day_05_ListSetMap.ArrayListArr;

public class Student {

    private String name;

    private int age;

    private String Attribute;


    public Student(String name, int age, String attribute) {
        this.name = name;
        this.age = age;
        Attribute = attribute;
    }

    public Student(String xiaoyan, int i) {
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

    public String getAttribute() {
        return Attribute;
    }

    public void setAttribute(String attribute) {
        Attribute = attribute;
    }
}
