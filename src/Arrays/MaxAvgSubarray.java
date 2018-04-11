package Arrays;

/**
 * Created by ajothomas on 4/10/18.
 */
public class MaxAvgSubarray {
  public static double findMaxAverage(int[] nums, int k) {
    int i = 0;
    int sum = 0;
    for (; i < k; i++) {
      sum += nums[i];
    }
    double maxSoFar = (double) sum / (double) k;
    for (; i < nums.length; i++) {
      sum = sum - nums[i - k] + nums[i];
      maxSoFar = Math.max(maxSoFar, ((double) sum / (double) k));
    }
    return maxSoFar;
  }

  public static void main(String args[]) {
    int nums[] = {1, 12, -5, -6, 50, 3};
    System.out.println(findMaxAverage(nums, 4));
  }
}
