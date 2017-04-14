package DP;

/**
 * Created by ajothomas on 4/10/17.
 */
public class LongestPalindromicSubsequence {
    public static void main(String args[]) {
        String input = "abaxyaba";
        char arr[] = input.toCharArray();
        int arrLen = arr.length;
        int T[][] = new int[arrLen][arrLen];

        // setting all to 1
        for (int i = 0; i < arrLen; i++)
            T[i][i] = 1;

        for (int currLength = 2; currLength <= arrLen; currLength++) {
            for (int i = 0; i < (arrLen - currLength + 1); i++) {
                int j = i + currLength - 1;
                if (currLength == 2 && arr[i] == arr[j]) {
                    T[i][j] = 2;
                } else if (arr[i] == arr[j]) {
                    T[i][j] = 2 + T[i+1][j-1];
                }
                else {
                    T[i][j] = Math.max(T[i+1][j], T[i][j-1]);
                }
            }
        }
        System.out.println("Longest palindromic subsequence size : "+T[0][arrLen-1]);
    }
}
