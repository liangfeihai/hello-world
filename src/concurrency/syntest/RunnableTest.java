package concurrency.syntest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RunnableTest implements Runnable {
    private  int tick=60;

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"---start");
        while(true) {
            synchronized (this) {
                if (tick == 0) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "=====" + tick--);
            }
        }
    }

    public static void main(String[] args){
//        System.out.println("start");
//        RunnableTest runnableTest=new RunnableTest();
//        new Thread(runnableTest).start();
//        new Thread(runnableTest).start();
//        System.out.println("end");

        List list=new ArrayList();
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if ((int)o1>(int)o2)
                    return -1;
                else if ((int)o1<(int)o2)
                    return 1;
                else
                return 0;
            }
        };
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(0);
        list.sort(c);
//        Collections.sort(list);
        System.out.println(list);
    }
}
