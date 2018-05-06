package concurrency.syntest;

public class SynMethods {
    public void iA(String user){
        System.out.println("user:"+user);
    }

    public  synchronized void isSyncA(String user) throws InterruptedException {
        System.out.println("start-user:"+user+"is using isSyncA,start");
        System.out.println(Thread.currentThread().getName()+",time:"+System.currentTimeMillis());
        for (int i=0;i<50;i++){
            Thread.sleep(1000);
        }
        System.out.println(Thread.currentThread().getName()+",time:"+System.currentTimeMillis());
        System.out.println("start-user:"+user+"is using isSyncA,end");
    }
    public  synchronized void isSyncB(String user) throws InterruptedException {
        System.out.println("start-user:"+user+"is using isSyncB,start");
        System.out.println(Thread.currentThread().getName()+",time:"+System.currentTimeMillis());
        for (int i=0;i<50;i++){
            Thread.sleep(1000);
        }
        System.out.println(Thread.currentThread().getName()+",time:"+System.currentTimeMillis());
        System.out.println("start-user:"+user+"is using isSyncB,end");
    }

    public static synchronized void cSyncA(){

    }

    public static synchronized void cSyncB(){

    }

    public static void main(String[] args) {
        SynMethods syn = new SynMethods();
        new Thread(){
            @Override
            public void run() {
                try {
                    syn.isSyncA("yi");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    syn.isSyncB("er");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        String test="123";
        test.equals("12");
        test.hashCode();
    }
}
