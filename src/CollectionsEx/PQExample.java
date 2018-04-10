package CollectionsEx;

import java.util.*;

/**
 * Created by ajothomas on 11/13/17.
 */

class IntegerComp implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
        return i2.compareTo(i1);
    }
}

public class PQExample {
    public static void main(String args[]) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new IntegerComp());
        pq.add(1);
        pq.add(3);
        pq.add(0);
        pq.add(5);
        pq.add(2);

        while(!pq.isEmpty())
            System.out.println(pq.poll());

    }
}
