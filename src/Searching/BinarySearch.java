package Searching;

/**
 * Created by ajothomas on 9/16/17.
 */
public class BinarySearch {

    public static boolean binary_search(int arr[], int num, int start, int end) {
        if(start<=end) {
            int middle = (start + end)/2;
            if(num==arr[middle])
                return true;
            else if(num<arr[middle])
                return binary_search(arr, num, start, middle-1);
            else
                return binary_search(arr, num, middle+1, end);
        }
        return false;
    }

    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int num = 10;
        System.out.println("Found : "+binary_search(arr, num, 0, arr.length-1));
    }
}
