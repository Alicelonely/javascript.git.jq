package day_02_Person;

public class Teacher extends Person{


    private  String job;

    Teacher(){}

    Teacher(String name,int age,String job){
        super(name,age);
        this.job = job;
    }

    public void show(){
        super.show();
        System.out.println("我的工作是"+job);
    }

}
