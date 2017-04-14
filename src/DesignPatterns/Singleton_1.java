package DesignPatterns;

/**
 * Created by ajothomas on 3/19/17.
 */

/* Eager Initialization */
class SingletonClass_1 {
    private static final SingletonClass_1 singletonObject = new SingletonClass_1();
    private SingletonClass_1(){
    }

    public static SingletonClass_1 getSingletonInstance() {
        return singletonObject;
    }
}

/* Eager Initialization :: static block */
class SingletonClass_2 {
    private static SingletonClass_2 singletonObject;
    private SingletonClass_2(){
    }

    static {
        try {
            singletonObject = new SingletonClass_2();
        }
        catch(Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static SingletonClass_2 getSingletonInstance() {
        return singletonObject;
    }
}

/* Lazy initialization */
class SingletonClass_3 {
    private static SingletonClass_3 singletonObject;
    private SingletonClass_3(){
    }



    public static SingletonClass_3 getSingletonInstance() {
        if(singletonObject == null){
            singletonObject = new SingletonClass_3();
        }
        return singletonObject;
    }
}

class BillPughSingleton {

    private BillPughSingleton(){}

    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}

public class Singleton_1 {

}
