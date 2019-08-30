package day_03_interface_abstract_duotai.MakingPizza;

public class Seafood extends Pizza{
    Seafood(){}

    Seafood(String attribute,int price,int size){
        super.attribute = attribute;
        super.price  = price;
        super.size = size;
    }

    @Override
    void show() {
        System.out.println("海鲜披萨：价格："+price+"大小"+size+"配料"+attribute);
    }
}
