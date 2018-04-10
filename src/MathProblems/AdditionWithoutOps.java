package MathProblems;

/**
 * Created by ajothomas on 10/27/17.
 */
/*Add two numbers without using arithmetic operators*/
public class AdditionWithoutOps {
    public static int sum(int x, int y)
    {
        if (y == 0)
            return x;
        else
            return sum( x ^ y, (x & y) << 1);
    }

    public static void main(String args[]) {
        System.out.printf("\n%d + %d = %d",10,20,sum(10,20));
    }
}
