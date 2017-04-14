package src.CollectionsEx;
import java.util.*;

/**
 * Created by ajothomas on 3/19/17.
 */
class MyComp implements Comparator<Integer>{

    @Override
    public int compare(Integer i1, Integer i2) {
        return i2.compareTo(i1);
    }

}
public class TreeMapPractise {

    public static void main(String args[]){
        TreeMap tMAP = new TreeMap<Integer, String>();
        tMAP.put(1,"One");
        tMAP.put(2,"Two");
        tMAP.put(3,"Three");
        tMAP.put(4,"Four");
        tMAP.put(8,"Eight");
        tMAP.put(6,"Six");
        tMAP.put(5,"Five");
        tMAP.put(7,"Seven");

        Set set = tMAP.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println("Key : "+entry.getKey()+", Value : "+entry.getValue());
        }

        TreeMap tMAP2 = new TreeMap<Integer, String>(new MyComp());
        tMAP2.put(1,"One");
        tMAP2.put(2,"Two");
        tMAP2.put(3,"Three");
        tMAP2.put(4,"Four");
        tMAP2.put(8,"Eight");
        tMAP2.put(6,"Six");
        tMAP2.put(5,"Five");
        tMAP2.put(7,"Seven");

        Set set1 = tMAP2.entrySet();
        Iterator it1 = set1.iterator();
        System.out.print("\n");
        while(it1.hasNext()){
            Map.Entry entry = (Map.Entry)it1.next();
            System.out.println("Key : "+entry.getKey()+", Value : "+entry.getValue());
        }

        TreeMap tMAP3 = new TreeMap<Integer, ArrayList<String>>();

    }
}
