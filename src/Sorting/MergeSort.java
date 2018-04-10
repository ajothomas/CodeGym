package src.Sorting;

/**
 * Created by ajothomas on 3/21/17.
 */
public class MergeSort {
  public static void printArr(int arr[]) {
    for (int element : arr) {
      System.out.print(element + ",");
    }
  }

  public static void merge(int arr[], int left, int middle, int right) {
    int length = right - left + 1;
    int[] tempArr = new int[length];
    int i = left, j = middle + 1, k = 0;

    while (i <= middle && j <= right) {
      if (arr[i] < arr[j])
        tempArr[k++] = arr[i++];
      else
        tempArr[k++] = arr[j++];
    }

    while (i <= middle)
      tempArr[k++] = arr[i++];
    while (j <= right)
      tempArr[k++] = arr[j++];

    for (int element : tempArr)
      arr[left++] = element;
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
    int arr[] = {11, 3, 4, 5, 1, 9, 10, 12};
    System.out.println("\nInitial Array");
    printArr(arr);
    mergeSortUtil(arr, 0, arr.length - 1);
    System.out.println("\nSorted Array");
    printArr(arr);
  }
}
