package Amazon;

/**
 * Created by ajothomas on 9/16/17.
 */
public class Matrix90 {
    public static void displayMatrix(int N, int mat[][]) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.printf("%3d",mat[i][j]);
            }
            System.out.println("");
        }
    }

    public static void rotate90Matrix(int N, int mat[][]) {
        for(int x=0;x<N/2;x++) {
            for(int y=x; y<N-x-1; y++) {
                int temp = mat[x][y];
                mat[x][y] = mat[y][N-x-1];
                mat[y][N-x-1] = mat[N-x-1][N-y-1];
                mat[N-x-1][N-y-1] = mat[N-y-1][x];
                mat[N-y-1][x] = temp;
            }
        }
    }
    public static void main(String args[]) {
        int mat[][] =
        {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int N = mat[0].length;
        displayMatrix(N,mat);
        rotate90Matrix(N,mat);
        // Print rotated matrix
        displayMatrix(N,mat);
    }
}
