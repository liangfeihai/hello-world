package concurrency.threadtest;

public class ThreadDemo2 {
    public static void main(String[] args){
        RDemo rDemo=new RDemo();
        new Thread(rDemo).start();
    }
}

class RDemo implements Runnable{
    @Override
    public void run(){
        for (int i=0;i<60;i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}