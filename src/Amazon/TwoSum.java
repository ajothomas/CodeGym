package Amazon;

import java.util.HashMap;

/**
 * Created by ajothomas on 9/16/17.
 */
public class TwoSum {
    public static void main(String args[]) {
        int arr[] = {2, 7, 11, 15}, target = 9;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int x:arr) {
            if(!hm.containsKey(target-x)) {
                hm.put(x,x);
            }
            else {
                System.out.printf("Found : (%d, %d)",x,target-x);
            }
        }
    }
}
