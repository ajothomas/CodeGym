package src.DP;

/**
 * Created by ajothomas on 3/16/17.
 */
public class LongestIncreasingSubsequence {
    static void bottomsUp(int arr[]){
        int length = arr.length;
        int minLenArr[] = new int[length];
        int maxLength = -1;

        // initial default length of 1
        for(int i=0; i<length; i++)
            minLenArr[i] = 1;

        for(int i=1; i<arr.length; i++){
            for(int j=0;j<i;j++) {
                if (arr[i] > arr[j] && minLenArr[j] >= minLenArr[i]) {
                    minLenArr[i] = minLenArr[j] + 1;
                }
            }
        }


        for ( int i = 0; i < minLenArr.length; i++ ){
            System.out.print(minLenArr[i]+",");
            if ( maxLength < minLenArr[i] )
                maxLength = minLenArr[i];
        }

        System.out.println("Increasing subarray length : "+maxLength);
    }
    public static void main(String args[]){
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        //int arr[] = {10, 22, 9, 33};
        bottomsUp(arr);
    }
}
