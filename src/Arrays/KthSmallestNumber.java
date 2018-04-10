package Arrays;
import java.util.Arrays;
/**
 * Created by ajothomas on 9/13/17.
 */
public class KthSmallestNumber {

    public static int KSMPivot(int arr[], int left, int right) {
        int pivot = arr[right];
        int i = 0;
        int j = right-1;

        while(true) {
            while(arr[i]<=pivot && i<right) {
                i++;
            }
            while(arr[j]>pivot && j>left) {
                j--;
            }
            if(i>=j) {
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        arr[right] = arr[i];
        arr[i] = pivot;

        return i;
    }


    public static int KSMUtil(int arr[], int k, int left, int right) {
        if(left<right) {

            int pivotPos = KSMPivot(arr, left, right);
            System.out.println("Hello : "+pivotPos);
            if(pivotPos == k) {
                return arr[k];
            }
            else if(k<pivotPos) {
                return KSMUtil(arr, k, left, pivotPos-1);
            }
            else {
                return KSMUtil(arr, k, pivotPos, right);
            }
        }
        else{
            return -1;
        }

    }

    public static void main(String args[]) {
        int arr[] = {5, 4, 1, 2, 3, 5, 7};
        int k = 4;
        int number = KSMUtil(arr, k-1, 0, arr.length-1);
        System.out.printf("The %dth smallest number is : %d", k, number);
        System.out.println("\nArray : "+Arrays.toString(arr));
    }
}