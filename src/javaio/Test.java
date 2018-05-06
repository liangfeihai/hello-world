package javaio;

import concurrency.threadtest.shoes.ThreadPacker;

import java.io.IOException;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    ServerNormal.start();
                    ServerBetter.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(100);
        char operators[] = {'+','-','*','/'};
        Random random=new Random(System.currentTimeMillis());
        new  Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    String expression= random.nextInt(10)+""+operators[random.nextInt(4)]+
                            (random.nextInt(10)+1);
                    Client.send(expression);
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
