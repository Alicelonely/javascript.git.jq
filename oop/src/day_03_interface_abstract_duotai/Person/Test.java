package day_03_interface_abstract_duotai.Person;

public class Test {

    public static void main(String[] args) {
        Person c = new Chinese("小明",12);

        Person a = new American("rose",15);

        c.show();
        a.show();

        c.say();
        a.say();
    }

}
