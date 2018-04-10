package DivideConquer;

/**
 * Created by ajothomas on 9/19/17.
 */
public class power {
    public static int powerFunc(int num, int pow) {
        if(pow==1)
            return num;
        else {
            int temp = powerFunc(num, pow/2);
            if(pow%2==0)
                return temp*temp;
            else
                return num*temp*temp;
        }
    }
    public static void main(String args[]) {
        System.out.println("Power : "+powerFunc(2,10));
    }
}
