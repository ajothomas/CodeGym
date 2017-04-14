package src.JavaMisc;

/**
 * Created by ajothomas on 3/24/17.
 */
public class GarbageCollection {
    public void finalize(){System.out.println("object is garbage collected 1");}
    public static void main(String args[]){
        GarbageCollection s1=new GarbageCollection();
        GarbageCollection s2=new GarbageCollection();
        s1=null;
        s2=null;
        System.gc();
    }

}
