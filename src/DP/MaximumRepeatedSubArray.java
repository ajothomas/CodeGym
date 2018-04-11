package DP;

/**
 * Created by ajothomas on 4/11/18.
 */
public class MaximumRepeatedSubArray {
  public static void main(String args[]) {
    int[] arr1 = {1, 2, 3, 2, 1};
    int[] arr2 = {3, 2, 1, 4, 7};
    System.out.println(findLength(arr1, arr2));
  }

  public static int findLength(int[] A, int[] B) {
    int max = 0;
    int[][] mat = new int[A.length + 1][B.length + 1];
    for (int i = 1; i <= A.length; i++) {
      for (int j = 1; j <= B.length; j++) {
        if (A[i - 1] == B[j - 1]) {
          mat[i][j] = 1 + mat[i - 1][j - 1];
          max = Math.max(mat[i][j], max);
        }
      }
    }

    return max;
  }
}
