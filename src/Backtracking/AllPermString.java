package Backtracking;

/**
 * Created by ajothomas on 8/29/17.
 */
public class AllPermString {
    public static void allPermUtil(char arr[], int current)
    {
        if (current == arr.length-1)
        {
            System.out.println(String.valueOf(arr));
        }
        else
        {
            char[] tempArr = new char[arr.length];
            for (int i = 0; i < arr.length; i++)
                tempArr[i]=arr[i];

            for (int i = current; i < arr.length; i++)
            {
                char temp = tempArr[i];
                tempArr[i] = tempArr[current];
                tempArr[current] = temp;

                allPermUtil( tempArr, current + 1);
            }
        }
    }

    public static void main(String args[])
    {
        String str = "ABC";
        char arr[] = str.toCharArray();
        allPermUtil(arr, 0);
    }
}
