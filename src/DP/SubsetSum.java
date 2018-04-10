package DP;

/**
 * Created by ajothomas on 8/29/17.
 */
public class SubsetSum {

    public static void subsetSumDP(int arr[], int targetSum, boolean targetSumArr[][])
    {
        for (int i = 0; i < arr.length; i ++)
        {
            for ( int j = 0; j <= targetSum; j++)
            {

            }
        }

        for (int i = 1; i <= targetSum; i++)
        {
            for (int j = 0; j<arr.length; j++)
            {
                if ( arr[j] == i )
                {
                   targetSumArr[i][j] = true;
                }
                else if( targetSumArr[i-1][j-1] == true && ( ( j + arr[j]) == i ) )
                {
                    targetSumArr[i][j] = true;
                }
            }
        }
    }

    public static void main(String args[])
    {
        int arr[] = {};
        int targetSum = 11;
        boolean targetArr[][] = new boolean[arr.length][targetSum+1];

        for (int i = 0; i < arr.length; i ++)
        {
            for (int j = 0; j <= targetSum ; j++)
            {
                if( j==0 )
                {
                    targetArr[i][j] = true;
                }
                else
                {
                    targetArr[i][j] = false;
                }
            }
        }
    }
}
