package concurrency.threadtest.shoes;

import java.util.Vector;

public class Launch {
    public static void main(String[] args) throws InterruptedException {
        final Vector<LeftAndRightQueue.Shoe> lQueue= new Vector<>();
        final Vector<LeftAndRightQueue.Shoe> rQueue= new Vector<>();
        boolean lFlag=true;
        boolean rFlag=false;

        LeftAndRightQueue queue = new LeftAndRightQueue(lQueue,rQueue,lFlag,rFlag);
        for (int i = 1; i <8 ; i++) {
            ThreadWorker worker = new ThreadWorker(queue);
            worker.start();
        }
        Thread.sleep(5000);
        ThreadMaster master = new ThreadMaster(queue);
        master.start();

        ThreadPacker packer = new ThreadPacker(queue);
        packer.start();
    }

}
