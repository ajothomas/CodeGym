package DP;

/**
 * Created by ajothomas on 11/4/17.
 */
public class NumUniquePaths {
    public static int countUniquePaths(int i, int j, int m, int n) {
        if(i<m-1 && j<n-1) {
            return countUniquePaths(i+1, j, m, n)+countUniquePaths(i, j+1, m, n);
        }
        else if(i==m-1 && j==n-1) {
            return 1;
        }
        else if(i==m-1)
            return countUniquePaths(i, j+1, m, n);
        else
            return countUniquePaths(i+1, j, m, n);

    }
    public static void main(String args[]) {
        System.out.println("Num Unique Paths : "+countUniquePaths(0,0,2,2));
    }
}
