package MultiThreading;

/**
 * Created by ajothomas on 11/18/17.
 */
class Counter{

    int count = 0;

    public synchronized void add(int value){
        this.count += value;
    }
}

class CounterThread extends Thread{

    protected Counter counter = null;
    public int waitTime = 0;
    public CounterThread(Counter counter, String threadName, int waitTime){
        super(threadName);
        this.counter = counter;
        this.waitTime = waitTime;
    }

    public void run() {
        for(int i=0; i<10; i++){
            counter.add(i);
            System.out.printf("\nThread:%s %d :: Counter:%d",Thread.currentThread().getName(), i, counter.count);
            try {
                Thread.sleep(waitTime);
            }
            catch(InterruptedException e) {

            }
        }
    }
}


public class SyncExample {
    public static void main(String[] args){
        Counter counter = new Counter();
        Thread  threadA = new CounterThread(counter, "TA",500);
        Thread  threadB = new CounterThread(counter, "TB",300);

        threadA.start();
        threadB.start();
    }
}
