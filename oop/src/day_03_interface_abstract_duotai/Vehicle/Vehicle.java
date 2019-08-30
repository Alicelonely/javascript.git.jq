package day_03_interface_abstract_duotai.Vehicle;

public class Vehicle implements Cart,Ship,Aircarft {
    @Override
    public void Aircarft() {
        System.out.println("在空中飞行");
    }

    @Override
    public void Cart() {
        System.out.println("在陆地上奔跑");
    }

    @Override
    public void Ship() {
        System.out.println("在海上滑行");
    }
}
