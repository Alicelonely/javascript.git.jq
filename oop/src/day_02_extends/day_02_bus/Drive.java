package day_02_bus;

public class Drive {
    Drive(){

    }


    Drive(Cart c){
        System.out.println("司机开的是轿车");
    }

    Drive(Bus b){
        System.out.println("司机开的是客车");
    }

    Drive(Guycart g){
        System.out.println("司机开的是货车");
    }
}
