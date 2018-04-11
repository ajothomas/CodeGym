package Arrays;

/**
 * Created by ajothomas on 4/8/17.
 */
public class MaxSubarraySum {
  public static void maxSubarray(int arr[]) {
    int max_so_far = arr[0];
    int curr_max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      curr_max = Math.max(arr[i], curr_max + arr[i]);
      max_so_far = Math.max(curr_max, max_so_far);
    }

    System.out.println("Maximum sum : " + max_so_far);
  }

  public static void main(String args[]) {
    //minMaxDifference();
    int arr[] = {-2};
    maxSubarray(arr);
  }
}
