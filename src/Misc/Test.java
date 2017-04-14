package src.Misc;

/**
 * Created by ajothomas on 3/26/17.
 */
public class Test {
    static int reverse(int number){
        int remainder;
        int result=0;
        while(number!=0){
            remainder = number%10;
            result = (result*10)+remainder;
            number = number/10;
        }

        return result;
    }
    public static void main(String args[]){
        System.out.println(reverse(reverse(4358)+reverse(754)));
    }
}
