package LinkedList;

/**
 * Created by ajothomas on 3/4/17.
 */
public class MiscSet1 {

    static long computePower(int x, int y){
        if(y==1)
            return x;
        int temp = y/2;
        long res = computePower(x, temp);
        if(y%2==0)
            return res*res;
        else
            return x*res*res;
    }

    static int findMax(int arr[]){
        int max=-99999;
        for(int i=0; i<arr.length; i++)
            max = arr[i]>max?arr[i]:max;

        return max;
    }

    static void countingSort(){
        int arr[] = {1, 4, 1, 2, 7, 5, 2};
        int max = findMax(arr)+1;
        int count[] = new int[max];
        for(int i=0; i<max; i++)
            count[i]=0;

        System.out.println(arr.length);
        System.out.println(max);
        for(int i=0; i<arr.length; i++)
            count[arr[i]] = count[arr[i]] + 1;

        int tempCount = 0;
        for(int i=0; i<max; i++){
            if(count[i]!=0) {
                tempCount = count[i];
                while(tempCount>0) {
                    System.out.print(i+" ,");
                    tempCount--;
                }
            }
        }
    }

    public static void main(String args[]){

        // optimal way of computing power
        long x = computePower(2,5);
        System.out.println(x);

        //
        countingSort();

    }
}
