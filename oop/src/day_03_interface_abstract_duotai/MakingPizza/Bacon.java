package day_03_interface_abstract_duotai.MakingPizza;

public class Bacon extends Pizza{


    Bacon(){}

    Bacon(String attribute,int price,int size){
        super.attribute = attribute;
        super.price  = price;
        super.size = size;
    }

    @Override
    void show() {
        System.out.println("名称：培根披萨。价格："+price+"大小："+size+"培根个数"+attribute);
    }
}
