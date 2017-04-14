/**
 * Created by ajothomas on 3/4/17.
 */

public class RecursionProblemsSet1 {
    static void allStringPermUtil(String input, String curr, int position){
        if(curr.length()==input.length())
            System.out.println(curr);
        else {
            for(int i=0; i<input.length(); i++){
                allStringPermUtil(input, curr+Character.toString(input.charAt(i)), position);
            }
        }
    }

    static void allStringPerm() {
        String str = "ABC";
        for(int i=0;i<str.length();i++)
            allStringPermUtil(str, ""+Character.toString(str.charAt(i)), 3);
    }

    //Print all possible strings that can be made by placing spaces
    static void allStringsWithSpaceUtil(String input, String curr, int currLength) {
        String str = "ABC";
        if(input.length()==currLength){
            System.out.println(curr);
        }
        else {
            allStringsWithSpaceUtil(input, curr+"*"+Character.toString(input.charAt(currLength)), currLength+1);
            allStringsWithSpaceUtil(input, curr+Character.toString(input.charAt(currLength)), currLength+1);
        }
    }

    static void allStringsWithSpace() {
        String input = "ABCD";
        allStringsWithSpaceUtil(input, "A", 1);
    }

    public static void main(String args[]) {
        //allStringPerm();
        allStringsWithSpace();
    }
}
