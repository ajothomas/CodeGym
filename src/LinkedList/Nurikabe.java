package LinkedList;

import java.util.regex.Pattern;
/**
 * Created by ajothomas on 3/4/17.
 */
public class Nurikabe {
    static boolean checkWaterSquareUtil(int i, int j, int rows, int columns, String arr[][]){
        if(i>=0 && j>=0 && i+2<=rows && j+2<=columns){
            if(arr[i][j].equals(".") && arr[i][j+1].equals(".") && arr[i+1][j].equals(".") && arr[i+1][j+1].equals(".") )
                return true;
            else return false;
        }
        else
            return false;
    }
    static boolean checkWaterSquare(String arr[][], int i, int j, int rows, int columns){
        //quad1
        boolean quad1 = checkWaterSquareUtil(i-1,j  ,rows,columns, arr);
        //quad2
        boolean quad2 = checkWaterSquareUtil(i-1,j-1,rows,columns, arr);
        //quad3
        boolean quad3 = checkWaterSquareUtil(i  ,j-1,rows,columns, arr);
        //quad4
        boolean quad4 = checkWaterSquareUtil(i  ,j  ,rows,columns, arr);

        return quad1||quad2||quad3||quad4;
    }

    static boolean checkHashNum(int i, int j, int rows, int columns, String arr[][]){
        if(i>=0 && j>=0 && i<rows && j<columns){
            String regex = "[0-9]+";
            if(arr[i][j].equals("#") || arr[i][j].matches(regex)){
                return true;
            }

            else return false;
        }
        else
            return false;
    }

    static boolean firstCase(String arr[][], int i, int j, int rows, int columns, int numCountFound[]) {
        String regex = "[0-9]+";
        if(arr[i][j].matches(regex)){
            numCountFound[0] = Integer.parseInt(arr[i][j]);
            numCountFound[2] = numCountFound[2]+1;
        }
        String currSquare =  arr[i][j];
        arr[i][j] = "~";
        numCountFound[1]++;
        if(numCountFound[2]>1)
            return false;

        boolean quad1 = checkHashNum(i - 1, j, rows, columns, arr);
        //quad2
        boolean quad2 = checkHashNum(i   , j - 1, rows, columns, arr);
        //quad3
        boolean quad3 = checkHashNum(i   , j + 1, rows, columns, arr);
        //quad4
        boolean quad4 = checkHashNum(i + 1, j  , rows, columns, arr);

        if (!quad1 && !quad2 && !quad3 && !quad4){
            System.out.println("Count : "+numCountFound[1]+", number : "+numCountFound[0]);
            if (numCountFound[1]== numCountFound[0]){
                System.out.println("Count : "+numCountFound[1]+", number : "+numCountFound[0]);
                return true;
            }
        }

        else
        {
            boolean b1=false, b2=false, b3=false, b4=false;
            if(quad1==true)
                b1 = firstCase(arr, i - 1, j  , rows, columns, numCountFound);
            if(quad2==true)
                b2 = firstCase(arr, i , j-1 , rows, columns, numCountFound);
            if(quad3==true)
                b3 = firstCase(arr, i, j + 1, rows, columns, numCountFound);
            if(quad4==true)
                b4 = firstCase(arr, i+1 , j   , rows, columns, numCountFound);
            return (b1 || b2 || b3 || b4);
        }
        return false;
    }

    // utility for checking if squares are connected
    static void waterSquaresConnectedUtil(String arr[][], int i, int j, int rows, int columns){
        if(i>=0 && j>=0 && i<rows && j<columns && arr[i][j].equalsIgnoreCase(".")) {
            arr[i][j] = "~";
            int browse[] = {-1, 0 ,1};
            for(int m=0; m<browse.length; m++){
                for(int n=0; n<browse.length; n++){
                    waterSquaresConnectedUtil(arr, i+browse[m], j+browse[n], rows, columns);
                }
            }
        }
    }

    // Check if water squares are connected
    static boolean waterSquaresConnected(String arr[][], int rows, int columns){
        int flag = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(flag == 0 && arr[i][j].equalsIgnoreCase(".")){
                    flag = 1;
                    waterSquaresConnectedUtil(arr, i, j, rows, columns);
                }
                else if(flag==1 && arr[i][j].equalsIgnoreCase("."))
                    return false;
            }
        }
        if(flag==0)
            return false;
        return true;
    }

    // only numbers and islands and water permitted
    static boolean strayChars(String arr[][], int rows, int columns){
        String regex = "[0-9]+";
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(!(arr[i][j].equals(".") || arr[i][j].equals("#") || arr[i][j].matches(regex)))
                    return true;
            }
        }
        return false;
    }

    static String[][] copyArr(String arr[][], int rows, int columns){
        String newArr[][] = new String[rows][columns];

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                newArr[i][j] = arr[i][j];
            }
        }

        return newArr;
    }

    public static void main(String args[]){
//        String arr[][] =
//                {         {".", "#", "2", ".", "1"}
//                        , {".", ".", ".", ".", "."}
//                        , {"#", "2", ".", "#", "."}
//                        , {".", ".", ".", "2", "."}
//                        , {"#", "", ".", ".", "1"}
//                };

        String arr[][] =
                {         {"#", "#", "3", ".", "."}
                        , {".", ".", ".", ".", "."}
                        , {"", "2", ".", "#", "."}
                        , {".", ".", ".", ".", "."}
                        , {"#", "2", ".", ".", "."}
                };

        int rows = arr.length;
        int columns = arr[0].length;

        boolean twoBlockFlag = false;
        boolean firstCaseFlag = true;
        boolean waterConnectedCheckFlag = false;
        boolean strayCharsAbsentFlag = false;

        String arr1[][] = copyArr(arr, rows, columns);
        String arr2[][] = copyArr(arr, rows, columns);
        String arr3[][] = copyArr(arr, rows, columns);

        System.out.println("Value of array :" + arr2[0][0]);

        strayCharsAbsentFlag = strayChars(arr3, rows, columns);
        System.out.println("Stray character : "+strayCharsAbsentFlag);

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(arr[i][j].equals("."))
                    twoBlockFlag = twoBlockFlag || checkWaterSquare(arr, i , j, rows, columns);

            }
        }

        int numCountFound[] = {-1,0,0};

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                // twotwo check
                if(arr1[i][j].equals("#")){
                    firstCaseFlag = firstCaseFlag && firstCase(arr, i , j, rows, columns, numCountFound);
                    numCountFound[0] = -1;
                    numCountFound[1] = 0;
                    numCountFound[2] = 0;
                }

            }
        }
        System.out.println("First case  : "+firstCaseFlag);

        waterConnectedCheckFlag = waterSquaresConnected(arr2, rows, columns);
        System.out.println("Water connected : "+waterConnectedCheckFlag);


//        if(waterConnectedCheckFlag && firstCaseFlag && twoBlockFlag)
//            return true;
//        else
//            return false;
    }
}
