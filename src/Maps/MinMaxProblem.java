package Maps;
import java.util.*;
import java.util.Collections;
/**
 * Created by ajothomas on 11/19/17.
 */

public class MinMaxProblem {
    public long[] implement(String[] ops, int nums[]) {
        Queue<Integer> minQueue = new PriorityQueue<>();
        Queue<Integer> maxQueue = new PriorityQueue<>(ops.length, Collections.reverseOrder());
        long[] product=new long[ops.length];
        for(int i=0; i<ops.length; i++) {
            if(ops[i].equalsIgnoreCase("push")) {
                minQueue.offer(nums[i]);
                maxQueue.offer(nums[i]);
                product[i]=((long)minQueue.peek()*(long)maxQueue.peek());
                System.out.printf("\nMin:%d, Max:%d, Prod:%d",minQueue.peek(),maxQueue.peek(),product[i]);
            }
            else {
                minQueue.remove(nums[i]);
                maxQueue.remove(nums[i]);
                product[i]=((long)minQueue.peek()*(long)maxQueue.peek());
                System.out.printf("\nMin:%d, Max:%d, Prod:%d",minQueue.peek(),maxQueue.peek(),product[i]);
            }
        }

        return product;
    }
    public static void main(String args[]) {
        String[] ops = {"push", "push", "push", "pop"};
        int[] nums = {1, 2, 3, 1};
        MinMaxProblem prob = new MinMaxProblem();
        System.out.println("Prod :"+prob.implement(ops, nums));
    }
}
