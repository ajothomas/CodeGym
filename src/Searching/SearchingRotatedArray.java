package Searching;

/**
 * Created by ajothomas on 10/15/17.
 */
public class SearchingRotatedArray {
    public static int findPivot( int arr[], int left, int right) {
        if(right<=left)
            return -1;
        int middle = (left+right)/2;
        if(arr[middle]>arr[middle+1])
            return middle;
        if(arr[middle-1]>arr[middle])
            return middle-1;
        else if(arr[middle+1]>arr[right])
            return findPivot( arr, middle+1, right);
        else
            return findPivot( arr, left, middle-1);
    }

    public static void main(String args[]) {
        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        System.out.println("\nPivot : "+findPivot(arr1, 0, arr1.length-1));
        System.out.println("Index of the element is: ");
    }
}
