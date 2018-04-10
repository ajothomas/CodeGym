package DP;

/**
 * Created by ajothomas on 9/15/17.
 */
public class Fibonacci {
    static int table[];

    static void setArr(int n){
        table = new int[n+1];
        for(int i=0;i<table.length;i++)
            table[i] = -1;
    }
    public static int bottomsUp(int n) {
        for(int i=0; i<table.length; i++) {
            if(i==0)
                table[i] = 0;
            else if(i==1)
                table[i] = 1;
            else
                table[i] = table[i-1] + table[i-2];
        }
        return table[n];
    }

    public static int topBottom(int x) {
        if(x==0)
            return 0;
        else if(x==1)
            return 1;
        if(table[x]>-1)
            return table[x];
        else
            return (topBottom(x-1)+topBottom(x-2));
    }
    public static void main(String args[]) {
        int n = 6;
        setArr(n);
        //System.out.println("Fibonacci at n : "+bottomsUp(n));
        System.out.println("Fibonacci at n : "+topBottom(n));
    }
}
