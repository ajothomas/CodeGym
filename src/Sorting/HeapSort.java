package Sorting;

import java.util.Arrays;

/**
 * Created by ajothomas on 9/17/17.
 */
public class HeapSort {
    public void sort(int arr[]) {
        int n = arr.length;
        // you cannot call heapify function just once as it will heapify only one part of the tree. Left or right
        // heapify(arr, n, 0);

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // arr, size, index to heap from
    void heapify(int arr[], int n, int i) {
        int largest = i; // largest is root
        int left = i*2 + 1; // left
        int right = i*2 + 2; // right

        if(left<n && arr[left]>arr[largest])
            largest = left;
        if(right<n && arr[right]>arr[largest])
            largest = right;
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, n, largest);
        }
    }


    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;
        System.out.println("Before sorting : ");
        System.out.println(Arrays.toString(arr));
        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("After sorting : ");
        System.out.println(Arrays.toString(arr));
    }
}
