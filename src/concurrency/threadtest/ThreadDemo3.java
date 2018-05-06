package concurrency.threadtest;

public class ThreadDemo3 {
    public static void main(String[] args){
        Tiket tiket=new Tiket();
        Thread t1=new Thread(tiket,"窗口1");
        Thread t2=new Thread(tiket,"窗口2");
        Thread t3=new Thread(tiket,"窗口3");
        Thread t4=new Thread(tiket,"窗口4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Tiket implements Runnable{
    private int tiket=100;
    public void run(){
        while (true){
            synchronized (new Object()){
                try {
                    Thread.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if (tiket<=0){
                    System.out.println("票已卖光");
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"卖出一张票，当前余票"+--tiket);
            }
        }
    }
}