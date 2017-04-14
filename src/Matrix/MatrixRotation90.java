package Matrix;

/**
 * Created by ajothomas on 4/5/17.
 */
public class MatrixRotation90 {
    static void printArr(int arr[][]) {
        int rows = arr.length;
        int columns = arr[0].length;
        for (int i = 0; i < rows; i++) {
            System.out.println("");
            for (int j = 0; j < columns; j++) {
                System.out.format("%2d ",arr[i][j]);
            }
        }
    }

    static void rotateNotInplace(int arr[][]) {
        int rows = arr.length;
        int columns = arr[0].length;
        int newArr[][] = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newArr[j][i] = arr[i][j];
            }
        }
        printArr(newArr);
    }

    public static void main(String args[]) {
        int arr[][] = {{1, 2, 3, 4}
                , {5, 6, 7, 8}
                , {9, 10, 11, 12}
                , {13, 14, 15, 16}
                , {17, 18, 19, 20}
        };
        printArr(arr);
        rotateNotInplace(arr);

    }
}
