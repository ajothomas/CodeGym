package src.MultiThreading;

/**
 * Created by ajothomas on 3/27/17.
 */

class ThreadExample extends Thread{

    public void run(){
        for(int i=1;i<100;i=i+2){
            System.out.println("**"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunnableExample implements Runnable {

    public void run(){
        for(int i=2;i<100;i=i+2){
            System.out.println("##"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


public class MultiThreadTest {

    public static void main(String args[]){
        Thread t1 = new ThreadExample();
        t1.start();
        Thread t2 = new Thread(new RunnableExample(),"T2");
        t2.start();
    }
}
