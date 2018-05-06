package concurrency.threadtest.shoes;

public class ThreadPacker extends Thread {
    LeftAndRightQueue lrQueue;
    ThreadPacker(LeftAndRightQueue lrQueue){
        this.lrQueue=lrQueue;
    }
    @Override
    public void run(){
        while (true)
            while (!lrQueue.lQueue.isEmpty() && !lrQueue.rQueue.isEmpty()){
                LeftAndRightQueue.Shoe lShoe = lrQueue.lQueue.remove(0);
                LeftAndRightQueue.Shoe rShoe = lrQueue.rQueue.remove(0);
                System.out.println("打包线程，打包左鞋子和右鞋子，左鞋子库存"+lrQueue.lQueue.size()
                +"右鞋子库存"+ lrQueue.rQueue.size());
                pack(lShoe,rShoe);
            }
    }
    void pack (LeftAndRightQueue.Shoe lShoe,LeftAndRightQueue.Shoe rShoe){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
