package src.Sorting;

/**
 * Created by ajothomas on 3/19/17.
 */
public class Quicksort {

    public static void printArr(int arr[]){
        for(int element:arr){
            System.out.print(element+",");
        }
    }

    public static int quickSort(int arr[], int left, int right){
        int pivot = arr[right+1];
        int i=left, j=right;
        while(true){
            while(arr[i]<pivot && i<=right)
                i++;
            while(arr[j]>pivot && j>=left)
                j--;
            if(i>=j)
                break;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        arr[right+1] = arr[i];
        arr[i] = pivot;
        return i;
    }

    public static void quickSortUtil(int arr[], int left, int right){
        if(left<right){
            int partitionPosition = quickSort(arr, left, right-1);
            quickSortUtil(arr, left, partitionPosition-1);
            quickSortUtil(arr, partitionPosition+1, right);
        }
    }
    public static void main(String args[]){
        int arr[] = {2,1};
        System.out.println("\nInitial Array");
        printArr(arr);
        quickSortUtil(arr, 0, arr.length-1);
        System.out.println("\nSorted Array");
        printArr(arr);
    }
}
