package Arrays;

/**
 * Created by ajothomas on 9/11/17.
 */
public class ArrayRotation {
    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5,6,7};
        int n = 2;

        for(int i = 1; i <= n; i++) {
            int temp = arr[0];
            int j;
            for(j = 0; j < (arr.length - 1); j++) {
                arr[j] = arr[j+1];
            }
            arr[j] = temp;
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.format("%d ",arr[i]);
        }
    }
}
