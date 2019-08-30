package day_10_thread.bank;

public class Person2 extends Thread{
    Bank bank;

    public Person2(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (Bank.money >= 200) {
            bank.atm(200);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
