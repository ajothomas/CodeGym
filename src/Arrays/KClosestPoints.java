package Arrays;

/**
 * Created by ajothomas on 4/8/17.
 */
public class KClosestPoints {
    static int findCrossOverPoint(int low, int high, int x, int arr[]) {
        if (x >= arr[high])
            return high;
        if (x <= arr[low])
            return low;

        int mid = (low + high) / 2;
        if(arr[mid]<=x && arr[mid]>x)
            return mid;
        if(x<arr[mid])
            return findCrossOverPoint(low, mid-1, x, arr);

        return findCrossOverPoint(mid+1, high, x, arr);
    }
/*
    static void getKClosestPoints(int low, int high, int x, int arr[]) {

        return findCrossOverPoint(mid+1, high, x, arr);
    }
*/
    public static void main(String args[]) {
        int arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int k = 4;
        int x = 35;
        int crossoverIndex = findCrossOverPoint(0, arr.length - 1, x, arr);
        //getKClosestPoints(crossoverIndex, x, arr);
    }
}
