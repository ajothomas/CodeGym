package CollectionsEx;

import com.apple.concurrent.Dispatch;

import java.util.*;

/**
 * Created by ajothomas on 9/14/17.
 */
class MyComp implements Comparator<Integer>{

    @Override
    public int compare(Integer i1, Integer i2) {
        return i2.compareTo(i1);
    }

}
public class General {
    public static void HashMapImp() {
        HashMap<Integer,String> hm=new HashMap<Integer,String>();
        hm.put(100,"Amit");
        hm.put(101,"Vijay");
        hm.put(102,"Rahul");

        for(Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }

    public static void TreeMapImp() {
        TreeMap<Integer,String> tm=new TreeMap<>();
        tm.put(100,"Amit");
        tm.put(101,"Vijay");
        tm.put(102,"Rahul");

        Set set = tm.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println("Key : "+entry.getKey()+", Value : "+entry.getValue());
        }

        TreeMap<Integer,String> tm1=new TreeMap<>(new MyComp());
        tm1.put(100,"Amit");
        tm1.put(101,"Vijay");
        tm1.put(102,"Rahul");
        for(Map.Entry m:tm1.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }

    public static void QueueImp() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<5; i++)
            queue.add(i);
        // Display contents of the queue.
        System.out.println("Elements of queue : "+queue);
        System.out.println("Removed element (remove) : "+queue.remove());
        System.out.println("Removed element (poll) : "+queue.poll());
    }

    public static void HashSetImp() {
        HashSet<String> hs = new HashSet<>();

        // Add elements to the hash set.
        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");
        System.out.println(hs);
    }

    public static void TreeSetImp() {
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(10);
        ts.add(9);
        ts.add(1);
        ts.add(5);
        ts.add(11);

        System.out.println(ts);
    }

    public static void ListImp() {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        System.out.println(arr);

        Iterator<Integer> it = arr.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void PriorityQueueImp() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
        pq.add(1);
        pq.add(2);
        pq.add(4);
        pq.add(3);

        while(!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

    public static void main(String args[]) {
//        HashMapImp();
//        TreeMapImp();
//        QueueImp();
//        HashSetImp();
//        TreeSetImp();
//        ListImp();
        PriorityQueueImp();


    }
}
