package day_10_thread;

public class demo2 extends Thread{

    boolean operate = true;

    static int sum = 0;

    public demo2(boolean operate) {
        super();
        this.operate = operate;
    }

    @Override
    public void run() {
        super.run();
        while(true){
            if(operate){
                sum+=5;
                System.out.println(getName() + "加后,sum=" + sum);
            }else {
                sum-=4;
                System.out.println(getName() + "减后，sum=" + sum);
            }
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
