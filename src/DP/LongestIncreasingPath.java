package DP;

/**
 * Created by ajothomas on 11/11/17.
 */
public class LongestIncreasingPath {
    public int fillMatrix(int[][] matrix, int[][] T, int i, int j) {
        int rows = T.length;
        int cols = T[0].length;

        if(T[i][j]!=-1)
            return T[i][j];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x>=0 && y>=0 && x<rows && y<cols) {
                if(matrix[x][y]>matrix[i][j]) {
                    int len = 1+fillMatrix(matrix, T, x, y);
                    max = Math.max(max, len);
                }
            }
        }

        return T[i][j] = max;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        if(rows==0)
            return 0;
        int cols = matrix[0].length;
        int T[][] = new int[rows][cols];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++)
                T[i][j] = -1;
        }

        int result = Integer.MIN_VALUE;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(T[i][j]==-1)
                    T[i][j] = fillMatrix(matrix, T, i, j);
                result = Math.max(result, T[i][j]);
            }
        }
        return result;
    }
}
