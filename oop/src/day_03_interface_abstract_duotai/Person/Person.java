package day_03_interface_abstract_duotai.Person;

public abstract class Person {
    String name;
    int age;

    abstract void say();

    void show(){
        System.out.println(name+"------"+age);

    }
}
