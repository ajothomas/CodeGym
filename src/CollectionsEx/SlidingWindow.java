package CollectionsEx;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Created by ajothomas on 4/14/17.
 */
public class SlidingWindow {


    void slidingWindowImp2() {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        Deque<Integer> myQueue = new ArrayDeque<>();
        // for the window size k
        int i = 0;
        for (; i < k; i++) {
            while (!myQueue.isEmpty() && arr[i] >= myQueue.peekLast())
                myQueue.removeLast();

            myQueue.addLast(i);
        }

        for (; i < arr.length; i++) {
            System.out.format("\n[ %d - %d ] : %d", i-k , i, arr[myQueue.peekFirst()]);

            // removing all elements outside the window from the queue
            while(!myQueue.isEmpty() && myQueue.peekFirst()<=(i-k))
                myQueue.removeFirst();

            while (!myQueue.isEmpty() && arr[i] >= myQueue.peekLast())
                myQueue.removeLast();

            myQueue.addLast(i);
        }
        System.out.format("\n[ %d - %d ] : %d", i-k , i, arr[myQueue.peekFirst()]);

    }

    public static void main(String args[]) {
        SlidingWindow sw = new SlidingWindow();
        sw.slidingWindowImp2();
    }
}
