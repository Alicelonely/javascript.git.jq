package day_03_interface_abstract_duotai.Person;

public class American extends Person {

    American(){

    }

    American(String name,int age){
        super.age = age;
        super.name = name;
    }

    void  say(){
        System.out.println(name+"年龄："+age+"I am American");
    }

}
