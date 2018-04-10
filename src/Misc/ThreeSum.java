package Misc;
import java.util.*;

/**
 * Created by ajothomas on 11/10/17.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> output = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2 && nums[i]<1; i++) {
            int num1 = nums[i];
            int target = 0-num1;
            int x = i+1;
            int y = nums.length-1;
            while(x<y) {
                int sum = nums[x]+nums[y];
                if(sum==target)
                    break;
                else if(sum<target)
                    x++;
                else
                    y--;
            }
            if(x<y) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(num1);
                tempList.add(nums[x]);
                tempList.add(nums[y]);
                output.add(tempList);
                System.out.println(tempList);
            }
        }
        return new ArrayList<>(output);
    }

    public static void main(String args[]) {
        int[] arr = {0,0,0};
        List<List<Integer>> out = threeSum(arr);
    }
}
