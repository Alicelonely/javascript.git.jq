package day_10_thread;

public class demo1 extends Thread {

    public demo1() {
    }

    public demo1(String name) {
        super(name);
    }

    //票数
    static int ticket = 20;
    //锁
    static Object o = "aa";

    @Override
    public void run() {
        while (ticket > 0) {


                synchronized (o) {
                    if (ticket > 0) {
                        System.out.println(getName() + "卖出了" + ticket + "张票");
                        ticket--;
                    } else {
                        System.out.println("票卖完了");
                    }
                }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
