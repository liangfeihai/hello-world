package concurrency.threadtest.shoes;

public class ThreadMaster extends Thread {
    LeftAndRightQueue lrQueue;
    ThreadMaster(LeftAndRightQueue lrQueue){
        this.lrQueue=lrQueue;
    }
    @Override
    public void run(){
        while (true){
            if(lrQueue.lQueue.size()<lrQueue.rQueue.size()){
                lrQueue.lFlag=true;
                lrQueue.rFlag=false;
            }
            else {
                lrQueue.lFlag=false;
                lrQueue.rFlag=true;
            }
        }
    }
}
