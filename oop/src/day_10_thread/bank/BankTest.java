package day_10_thread.bank;

public class BankTest {

    public static void main(String[] args) {

        Bank bank = new Bank();

        Person1 personA = new Person1(bank);
        Person2 personB = new Person2(bank);

        personA.start();
        personB.start();


    }

}
