package DP;

/**
 * Created by ajothomas on 4/10/17.
 */
public class LongestPalindromicSubstring {
    public static void main(String args[]) {
        String input = "abbaxyaba";
        char arr[] = input.toCharArray();
        int arrLen = arr.length;
        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        boolean T[][] = new boolean[arrLen][arrLen];

        // setting all to 1
        for (int i = 0; i < arrLen; i++)
            T[i][i] = true;

        for (int i = 0; i < arrLen - 1; i++) {
            if (arr[i] == arr[i+1]) {
                T[i][i+1] = true;
                maxLength = 2;
                start = i;
            }
        }

        for (int currLength = 3; currLength <= arrLen; currLength++) {
            for (int i = 0; i < (arrLen - currLength + 1); i++) {
                int j = i + currLength - 1;
                if (arr[i] == arr[j] && T[i + 1][j - 1]) {
                    T[i][j] = true;
                    if (currLength > maxLength) {
                        start = i;
                        maxLength = currLength;
                    }
                }
            }
        }
        System.out.format("Start : %d, Length : %d, String : %s ", start, maxLength, input.substring(start, start + maxLength));
    }
}
