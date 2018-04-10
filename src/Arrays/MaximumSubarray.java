package Arrays;

/**
 * Created by ajothomas on 10/27/17.
 */
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0;i<nums.length;i++){
            currSum += nums[i];
            currSum = currSum>nums[i]?currSum:nums[i];
            maxSum = maxSum>currSum?maxSum:currSum;
        }

        return maxSum;
    }
    public static void main(String args[]) {
        int arr[] = {1,1,1,1,-999,1,1,1,1,-2};
        System.out.println("Max SumSubarray : "+maxSubArray(arr));
    }
}
