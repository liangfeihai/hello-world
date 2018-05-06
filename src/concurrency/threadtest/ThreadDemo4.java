package concurrency.threadtest;

/**
 * 生产消费机制一
 */
public class ThreadDemo4 {
    public static boolean flags=false;
    public static void main(String[] args){
        class Goods{
            private String name;
            private int num;
            public synchronized void produce(String name){
                if (flags){
                    try {
                        wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                this.name=name;
                System.out.println("生产了...."+this.name);
                flags=true;
                notifyAll();
            }
            public synchronized void consume(){
                if(!flags){
                    try {
                        wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("消费了******"+name);
                flags=false;
                notifyAll();
            }
        }
        final Goods g=new Goods();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    g.produce("商品");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    g.consume();
                }
            }
        }).start();

    }
}
