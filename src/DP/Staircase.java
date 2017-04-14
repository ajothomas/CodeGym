package DP;

import java.util.Scanner;

/**
 * Created by ajothomas on 3/16/17.
 */
public class Staircase {
    static int topDownArr[];

    static void setArr(int step){
        topDownArr = new int[step];
        for(int i=0;i<topDownArr.length;i++)
            topDownArr[i] = -1;
    }

    public static int topDownDP(int n){
        if(n==0){
            topDownArr[n]=1;
            return topDownArr[n];
        }
        else if(n==1){
            topDownArr[n]=2;
            return topDownArr[n];
        }
        else{
            if(topDownArr[n]==-1)
                topDownArr[n] = topDownDP(n-2)+ topDownDP(n-1);
            return topDownArr[n];
        }

    }

    public static int ways(int destination){
        if(destination==0)
            return 0;
        if(destination==1)
            return 1;
        int arr[] = new int[destination];
        arr[0]=1;
        arr[1]=2;
        for(int i=2;i<destination;i++)
            arr[i] = arr[i-1] + arr[i-2];
        return arr[destination-1];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int step = sc.nextInt();
        System.out.println("(Bottoms up DP) Number of ways to reach "+step+" step is : "+ways(step));

        setArr(step);
        System.out.println("(Top down DP) Number of ways to reach "+step+" step is : "+topDownDP(step-1));
    }
}
