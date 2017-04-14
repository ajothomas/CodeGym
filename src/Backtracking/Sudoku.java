package Backtracking;

import java.util.Arrays;

/**
 * Created by ajothomas on 4/11/17.
 */

public class Sudoku {


    public static void printGrid(int grid[][]) {
        for (int i = 0; i < grid.length; i++)
            System.out.println(Arrays.toString(grid[i]));
    }

    public static boolean checkValid(int grid[][], int a, int b, int value) {
        // check in row and column
        for (int i = 0; i < 9; i++) {
            if (grid[i][b] == value && i != a)
                return false;

            if (grid[a][i] == value && i != b)
                return false;
        }

        int SI = a / 3;
        int SJ = b / 3;
        for (int i = SI; i < (SI + 3); i++) {
            for (int j = SJ; j < (SJ + 3); j++) {
                if (grid[i][j] == value && i != a && j != b)
                    return false;
            }
        }
        return true;
    }

    public boolean findNext(int grid[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    // Cell()
                }

            }
        }
        return false;
    }

    public static boolean SolveSudoku(int grid[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    //if (checkValid
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        if (SolveSudoku(grid)) {
            System.out.println("Solution exists");
            printGrid(grid);
        } else
            System.out.println("No solution exists");
    }
}
