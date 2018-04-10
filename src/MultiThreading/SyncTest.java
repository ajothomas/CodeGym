package MultiThreading;

/**
 * Created by ajothomas on 11/13/17.
 */
class MyObject {
    public synchronized void foo(String name) {
        try {
            System.out.println("Thread " + name + ".foo(): starting");
            Thread.sleep(3000);
            System.out.println("Thread " + name + ".foo(): ending");
        } catch (InterruptedException exc) {
            System.out.println("Thread " + name + ": interrupted.");
        }
    }
}

class MyClass extends Thread {
    private String name;
    private MyObject myObj;

    public MyClass(MyObject obj, String n) {
        name = n;
        myObj = obj;
    }

    public void run() {
        myObj.foo(name);
    }
}
public class SyncTest {
    public static void main(String args[]) {
        MyObject obj = new MyObject();
        MyClass thread1 = new MyClass ( obj, "1");
        MyClass thread2 = new MyClass ( obj, "2");
        thread1.start();
        thread2.start();
    }
}
