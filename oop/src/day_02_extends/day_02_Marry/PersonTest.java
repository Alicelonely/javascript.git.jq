package day_02_extends;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("json",17,true,"rose");

        Person person2 = new Person("rose",16,false,"json");


        person1.isMarry(person2);


    }
}
