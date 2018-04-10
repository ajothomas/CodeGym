package DP;

/**
 * Created by ajothomas on 4/13/17.
 */
public class MinCostPath {
    public static int minCostPathUtil(int cost[][], int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (i == 0 && j == 0)
            return cost[i][j];
        else return cost[i][j] + MinOfThree(minCostPathUtil(cost, i - 1, j), minCostPathUtil(cost, i - 1, j - 1),
                minCostPathUtil(cost, i, j - 1));
    }

    public static int minCostPathUtil2(int cost[][]) {
        int rows = cost.length;
        int cols = cost[0].length;

        int T[][] = new int[rows][cols];

        T[0][0] = cost[0][0];
        for (int i=1;i<cols;i++)
            T[0][i] = cost[0][i] + T[0][i-1];

        for (int j=1;j<rows;j++)
            T[j][0] = cost[j][0] + T[j-1][0];

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                T[i][j] = cost[i][j] + MinOfThree(T[i][j-1], T[i-1][j-1], T[i-1][j]);
            }
        }

        return T[rows-1][cols-1];
    }

    public static int MinOfThree(int a, int b, int c) {
        return c < (a < b ? a : b) ? c : (a < b ? a : b);
    }

    public static void main(String args[]) {

        int cost[][] = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};


        int rows = cost.length - 1;
        int cols = cost[0].length - 1;
        System.out.println("Min cost path : " + minCostPathUtil2(cost));
        System.out.println("Min : " + MinOfThree(1,1, 1));
    }
}
