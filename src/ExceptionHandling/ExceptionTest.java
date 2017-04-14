package src.ExceptionHandling;

/**
 * Created by ajothomas on 3/22/17.
 */

class MyException extends Exception {
    public String toString(){
        return "MyException: Divide by zero";
    }
}

public class ExceptionTest {

    public static void test2() throws MyException{
        int d=0;
        if(d==0) {
            throw new MyException();
        }
    }

    public static void test1() throws Exception{
        int d=0;
        if(d==0) {
            throw new Exception("Divide by zero");
        }
    }
    public static void main(String args[]){
        try{
            test1();
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        try{
            test2();
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        System.out.println("Hello world");
    }
}
