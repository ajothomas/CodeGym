package DP;

import java.util.*;

/**
 * Created by ajothomas on 11/4/17.
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 */

public class CoinChange {
    public static int coinChangeFunc(int arr[], int amount) {
        Map<Integer,Integer> coinMap = new HashMap<>();
        for(int i=0; i<arr.length; i++)
            coinMap.put(arr[i], arr[i]);

        int numCoins[] = new int[amount];
        for(int i=0; i<numCoins.length; i++)
            numCoins[i] = -1;

        for(int i=0; i<numCoins.length; i++) {
            if(coinMap.containsKey(i+1)) {
                numCoins[i] = 1;
            }
            else {
                int min = Integer.MAX_VALUE;
                for(int j=0; j<arr.length; j++) {
                    int coinValue = arr[j];
                    if((i-coinValue)>=0) {
                        int prevValue = numCoins[i-coinValue];
                        if(prevValue>0) {
                            min = (prevValue+1)<min?(prevValue+1):min;
                        }
                    }
                }
                if(min<Integer.MAX_VALUE)
                    numCoins[i] = min;
            }
        }
        if(amount==0)
            return 0;
        return numCoins[amount-1];
    }

    public static int coinChangeFunc2(int arr[], int amount) {
        Map<Integer,Integer> coinMap = new HashMap<>();
        for(int i=0; i<arr.length; i++)
            coinMap.put(arr[i], arr[i]);

        int numCoins[] = new int[amount];
        for(int i=0; i<numCoins.length; i++)
            numCoins[i] = -1;

        for(int i=0; i<numCoins.length; i++) {
            int sum = 0;
            if(coinMap.containsKey(i+1)) {
                sum = 1;
            }

            for(int j=0; j<arr.length; j++) {
                int coinValue = arr[j];
                if((i-coinValue)>=0) {
                    int prevValue = numCoins[i-coinValue];
                    if(prevValue>0) {
                        sum += (prevValue+1);
                    }
                }
            }
            if(sum>0)
                numCoins[i] = sum;
        }
        if(amount==0)
            return 0;
        return numCoins[amount-1];
    }

    public static void main(String args[]) {
        int arr[] = {1,2,3};
        int amount = 4;
        System.out.println("Num coins : "+coinChangeFunc(arr, amount));
        System.out.println("Num ways : "+coinChangeFunc2(arr, amount));
    }
}
