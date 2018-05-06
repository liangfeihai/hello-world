package concurrency.threadtest;

public class ThreadDemo1 {
    public static void main(String[] args){
        Demo demo=new Demo();
        demo.start();
        for (int i=0;i<120;i++){
            System.out.println("main=="+Thread.currentThread().getName()+i);
        }
    }
}

class Demo extends Thread{
    public void run(){
        for (int i=0;i<60;i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
