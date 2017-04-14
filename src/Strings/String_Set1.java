package src.Strings;

/**
 * Created by ajothomas on 3/20/17.
 */


public class String_Set1 {

    // find permutations
    public static void permutations(String prefix, String input, int currSize, int size){
        if(prefix.length()==size){
            System.out.println(prefix);
            return;
        }
        else{
            for(int i=0; i<currSize; i++) {
                permutations(prefix + Character.toString(input.charAt(i)), input.substring(0, i) + input.substring(i + 1, currSize), currSize-1, size);
            }
        }
    }
    public static void main(String args[]){
        System.out.println("Hello world");
        String input = "ABC";
        permutations("", input, input.length(), input.length());
    }
}
