package MathProblems;
import java.util.Arrays;
/**
 * Created by ajothomas on 11/9/17.
 */
public class NextPermutation {
     public static void nextPermutationFun(int[] nums) {
         int i;
         for (i = nums.length - 1; i > 0; i--) {
             if (nums[i] > nums[i - 1])
                 break;
         }
         if (i == 0)
             Arrays.sort(nums);
         else {
             // smallest index greater than i-1
             int smallest_index = 0;
             int smallest_number = Integer.MAX_VALUE;
             for (int j = i + 1; j < nums.length; j++) {
                 if (nums[j] > nums[i-1] && nums[j] < smallest_number) {
                     smallest_number = nums[j];
                     smallest_index = j;
                 }
             }
             if (smallest_index > 0) {
                 int temp = nums[i - 1];
                 nums[i - 1] = nums[smallest_index];
                 nums[smallest_index] = temp;
             }
             else {
                 int temp = nums[i - 1];
                 nums[i - 1] = nums[i];
                 nums[i] = temp;
             }
             for(int ii=i;ii<nums.length-1;ii++){
                 for(int jj=ii+1;jj<nums.length;jj++){
                     if(nums[ii]>nums[jj]){
                         int temp = nums[ii];
                         nums[ii]=nums[jj];
                         nums[jj] = temp;
                     }
                 }
             }
         }
     }
    public static void main(String args[]) {
        int nums[] = {1,3,2};
        nextPermutationFun(nums);
        System.out.println(Arrays.toString(nums));
    }
}
