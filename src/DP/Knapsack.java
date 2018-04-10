package DP;

/**
 * Created by ajothomas on 9/15/17.
 */
public class Knapsack {
    public static int knapSack(int W, int wt[], int val[], int n) {
        int table[][] = new int[n+1][W+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=W; j++) {
                table[i][j] = 0;
            }
        }

        for(int i=1; i<=n; i++) {
            for(int w=1; w<=W; w++) {
               if(wt[i-1]<=w) {
                   table[i][w] = Math.max(table[i-1][w], table[i - 1][w - wt[i-1]] + val[i-1]);
               } else {
                   table[i][w] = table[i-1][w];
               }
            }
        }
        return table[n][W];
    }

    public static void main(String args[]) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
