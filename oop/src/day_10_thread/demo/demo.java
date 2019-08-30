
public class demo extends Thread {
    String name;
    int time, count = 0;

    public demo(String name,int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {

        try {
            while (true) {
                System.out.println(name);
                Thread.sleep(time);
                count++;
                if(count>20){
                    break;
                }
                System.out.println(name+"运行完成");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        demo d1 = new demo("线程一",12);
        demo d2 = new demo("线程二",15);

        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);

        t1.start();
        t2.start();
    }
}
