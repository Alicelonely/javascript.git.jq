package day_10_thread.bank;

public class Bank {

    //总钱数
    static int money = 1000;

    /**
     * 柜台取钱
     *
     * @param money
     */
    public void counter(int money) {
        Bank.money -= money;
        System.out.println("A取走了" + money + ",还剩" + (Bank.money));
    }

    public void atm(int money) {
        Bank.money -= money;
        System.out.println("B取走了" + money + ",还剩" + (Bank.money));
    }

}
