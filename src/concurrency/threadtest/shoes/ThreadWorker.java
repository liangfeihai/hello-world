package concurrency.threadtest.shoes;

public class ThreadWorker extends Thread {
    LeftAndRightQueue lrQueue;

    public ThreadWorker(LeftAndRightQueue lrQueue) {
        this.lrQueue = lrQueue;
    }

    @Override
    public void run() {
        while (true){
            if (lrQueue.lFlag){
                try {
                    Thread.sleep(4000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lrQueue.lQueue){
                    lrQueue.lQueue.add(new LeftAndRightQueue.Shoe(LeftAndRightQueue.Shoe.LEFT));
                    System.out.println(Thread.currentThread().getName()+"工作线程，生产左鞋子，左鞋子库存"
                            +lrQueue.lQueue.size()+"，右鞋子库存："+lrQueue.rQueue.size());
                }
            }
            else {
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lrQueue.rQueue){
                    lrQueue.rQueue.add(new LeftAndRightQueue.Shoe(LeftAndRightQueue.Shoe.RIGHT));
                    System.out.println(Thread.currentThread().getName()+"工作线程，生产右鞋子，右鞋子库存"
                            +lrQueue.rQueue.size()+"，左鞋子库存："+lrQueue.lQueue.size());
                }

            }

        }
    }
}
