package src.Arrays;

/**
 * Created by ajothomas on 3/20/17.
 */
public class Arrays_1 {
    public static void minMaxDifference() {
        //int arr[] = {4,3,5,6,7,1,2};
        int arr[] = {6, 1, 7, -1, 3, 5, 9};
        int min_number = Integer.MAX_VALUE;
        int max_diff = Integer.MIN_VALUE;
        int current_difference;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min_number)
                min_number = arr[i];
            current_difference = arr[i] - min_number;
            if (current_difference > max_diff)
                max_diff = current_difference;
        }
        System.out.println("Max diff : " + max_diff);
    }

    // Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times
    public static void findNumberOccurringOddTimes() {
        int arr[] = {1, 1, 2, 2, 3, 3, 3};
        int result = 0;
        for (int num : arr)
            result ^= num;
        System.out.println("Odd times occurring number : " + result);
    }

    public static void maxSubarray(int arr[]) {
        int max_so_far = arr[0];
        int curr_max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curr_max = Math.max(arr[i], curr_max+arr[i]);
            max_so_far = Math.max(curr_max, max_so_far);
        }

        System.out.println("Maximum sum : " + max_so_far);
    }

    public static void main(String args[]) {
        //minMaxDifference();
        findNumberOccurringOddTimes();
    }


}