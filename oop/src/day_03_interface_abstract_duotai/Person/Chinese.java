package day_03_interface_abstract_duotai.Person;

public class Chinese extends Person {

    Chinese(){

    }

    Chinese(String name,int age){
        super.age = age;
        super.name = name;
    }

    void say(){

        System.out.println(name+"年龄："+age+"我是中国人");
    }
}
