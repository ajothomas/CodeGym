package Recursion;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by ajothomas on 4/12/17.
 */
public class GreyCodeN {
    public static void greyCode(String curr, int n) {
        if (curr.length() == n) {
            System.out.println(curr);
            return;
        } else {
            greyCode(curr + "0", n);
            greyCode(curr + "1", n);
        }
    }

   // 0, 1
    // 1, 0
    // 00,01,10,11
        /**
     public class Solution {

     //  public static void greyCode(String curr, List<String> output, int n) {
     //     if(curr.length()==n){
     //         output.add(curr);
     //         return;
     //     }
     //     else {
     //         greyCode(curr+"0", output, n);
     //         greyCode(curr+"1", output, n);
     //     }
     // }

     public List<Integer> grayCode(int n) {
     List<Integer> output1 = new ArrayList<Integer>();
     List<String> output2 = new ArrayList<String>();
     StringBuilder str = new StringBuilder("0");
     for(int i=1;i<n;i++)
     str.append("0");
     if(n==0){
     output1.add(0);
     return output1;
     }
     if(n==1){
     output1.add(0);
     output1.add(1);
     return output1;
     }
     // 11
     output2.add(new String(str));
     int k=0;
     for(int i=0;i<Math.pow(n,2)-1;i++) {
     if(str.charAt(k)=='0')
     str.setCharAt(k, '1');
     else if(str.charAt(k)=='1')
     str.setCharAt(k, '0');
     output2.add(new String(str));
     k = (k+1)%n;
     }
     System.out.println(output2);
     for(String s:output2) {
     output1.add(Integer.parseInt(s,2));
     }
     return output1;
     }
     }
     */

    public static void greyCode2(int n) {
        List<Integer> output1 = new ArrayList<Integer>();
        List<String> output2 = new ArrayList<String>();
        StringBuilder str = new StringBuilder("0");
        for(int i=1;i<n;i++)
            str.append("0");
        if(n==0){
            output1.add(0);
        }
        else if(n==1){
            output1.add(0);
            output1.add(1);
        }
        else {
            // 11
            output2.add(new String(str));
            int k = 0;
            for (int i = 0; i < Math.pow(n, 2) - 1; i++) {
                if (str.charAt(k) == '0')
                    str.setCharAt(k, '1');
                else if (str.charAt(k) == '1')
                    str.setCharAt(k, '0');
                output2.add(new String(str));
                k = (k + 1) % n;
            }
            System.out.println(output2);

        }
    }


    public static void main(String args[]) {
        //greyCode("", 3);
        greyCode2(3);
    }
}
// 11
// 0

