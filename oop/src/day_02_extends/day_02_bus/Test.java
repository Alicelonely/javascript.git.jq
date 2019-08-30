package day_02_bus;

public class Test {
    public static void main(String[] args) {
        Cart c = new Cart();
        Bus b  = new Bus();
        Guycart g = new Guycart();

        Drive drive = new Drive(c);
        Drive drive1 = new Drive(b);
        Drive drive2 = new Drive(g);
    }
}
