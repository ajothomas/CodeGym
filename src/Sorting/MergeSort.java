package src.Sorting;

import java.util.Arrays;

/**
 * Created by ajothomas on 3/21/17.
 */
public class MergeSort {
  public static void merge(int arr[], int left, int middle, int right) {
    int[] tempArr = new int[right - left + 1];
    int i = left;
    int j = middle + 1;
    int k = 0;

    while (i <= middle && j <= right) {
      if (arr[i] < arr[j]) {
        tempArr[k++] = arr[i++];
      } else {
        tempArr[k++] = arr[j++];
      }
    }

    while (i <= middle) tempArr[k++] = arr[i++];
    while (j <= right) tempArr[k++] = arr[j++];

    for (int element: tempArr) {
      arr[left++] = element;
    }
  }

  public static void mergeSortUtil(int[] arr, int left, int right) {
    if (left < right) {
      int middle = (left + right) / 2;
      mergeSortUtil(arr, left, middle);
      mergeSortUtil(arr, middle + 1, right);
      merge(arr, left, middle, right);
    }
  }

  public static void main(String args[]) {
    int[] arr = {5, 3, 4, 1, 2, 7, 8, 6, 9, 0};
    System.out.println("Before Sort");
    System.out.println(Arrays.toString(arr));
    mergeSortUtil(arr, 0, arr.length - 1);
    System.out.println("After Sort");
    System.out.println(Arrays.toString(arr));
  }
}
