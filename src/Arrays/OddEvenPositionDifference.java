package Arrays;

/**
 * Created by ajothomas on 9/30/17.
 */
public class OddEvenPositionDifference {
    public static String winner(int andrea[], int maria[], String s) {
        int andrea_res = 0;
        int maria_res = 0;
        int start = 0;
        if(s.equals("Odd"))
            start = 1;

        for(int i=start;i<Math.min(andrea.length, maria.length);i=i+2) {
            andrea_res += (andrea[i]-maria[i]);
            maria_res += (maria[i]-andrea[i]);
        }

        if(andrea_res>maria_res)
            return "Andrea";
        else if(maria_res>andrea_res)
            return "Maria";
        return "Tie";
    }

    public static void main(String args[]) {
        int andrea_arr[] = {2,3,6,7};
        int maria_arr[] = {1,4,5,8};
        System.out.print(winner(andrea_arr, maria_arr, "Even"));
    }
}
