package day_10_thread.bank;

public class Person1 extends Thread {
    Bank bank;

    public Person1(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (Bank.money >= 100) {
            bank.counter(100);  //柜台取钱
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
