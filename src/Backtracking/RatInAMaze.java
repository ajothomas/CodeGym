package Backtracking;

/**
 * Created by ajothomas on 4/7/17.
 */
public class RatInAMaze {

    static void printArr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("");
            for (int j = 0; j < arr[0].length; j++) {
                System.out.format("%2d ", arr[i][j]);
            }
        }
    }

    static boolean checkCell(int arr[][], int i, int j) {
        int rows = arr.length;
        int cols = arr[0].length;
        if (i >= 0 && j >= 0 && i < rows && j < cols){
            if(arr[i][j]==1)
            return true;
        }
        return false;
    }

    static boolean ratMazeUtil(int arr[][], int sol[][], int i, int j) {
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            sol[i][j] = 1;
            return true;
        }
        if (checkCell(arr, i, j)) {
            sol[i][j] = 1;
            if (ratMazeUtil(arr, sol, i + 1, j) || ratMazeUtil(arr, sol, i, j + 1))
                return true;
            sol[i][j] = 0;
            return false;
        }
        return false;
    }

    public static void main(String args[]) {
        int arr[][] = {{1, 0, 0, 0}
                , {1, 1, 1, 1}
                , {0, 1, 0, 0}
                , {1, 1, 1, 1}
        };

        int rows = arr.length;
        int cols = arr[0].length;
        int sol[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                sol[i][j] = 0;
        }
        System.out.println("Initial Matrix");
        printArr(arr);
        if (ratMazeUtil(arr, sol, 0, 0) == false) {
            System.out.println("No solution");
        }
        System.out.println("\nResult Matrix");
        printArr(sol);
    }
}
