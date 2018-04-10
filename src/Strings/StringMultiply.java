package Strings;

/**
 * Created by ajothomas on 11/8/17.
 */
public class StringMultiply {
    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int arr1[] = new int[len1];
        int arr2[] = new int[len2];
        int result[] = new int[len1+len2];

        for(int i=0;i<len1;i++){
            arr1[i] = Character.getNumericValue(num1.charAt(i)) ;
            result[i] = 0;
        }

        for(int i=0;i<len2;i++){
            arr2[i] = Character.getNumericValue(num2.charAt(i)) ;
            result[i+len1] = 0;
        }

        // if any one of the numbers is 0
        if(arr1[0]==0||arr2[0]==0)
            return "0";

        for(int i=0; i<len2; i++) {
            int k=i;
            for(int j=0; j<len1; j++) {
                int prod = arr2[i]*arr1[j];
                int r = prod%10;
                int q = prod/10;
                result[k]+=q;
                result[k+1]+=r;
                k++;
            }
        }

        // propagating the carry
        String output="";
        int carry = 0;
        for(int i=result.length-1;i>=0;i--){
            int num = result[i]+carry;
            carry = num/10;
            if((i==0&num>0)||i>0)
                output = ""+(num%10)+output;
        }

        return output;
    }

    public static void main(String args[]) {
        System.out.println(multiply("111","11"));
    }
}
