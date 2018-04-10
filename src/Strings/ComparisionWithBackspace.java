package Strings;

/**
 * Created by ajothomas on 11/13/17.
 * Compare two strings after removing backspace in one.
 * Str 1 : ab~c~d = ad
 * Str 2 : ad
 * Str 1 and Str 2 are the same
 */
public class ComparisionWithBackspace {
    public static String treatString(String input) {
        char[] inputArr = input.toCharArray();
        int start = 0;
        int end = inputArr.length-1;
        if (inputArr[start]=='~' || inputArr[end]=='~')
            return input;

        start = 0;
        int curr = 1;
        while(curr<=end) {
            if(inputArr[curr]=='~') {
                inputArr[curr-1] = '~';
                start = Math.max(0, curr-2);
            }
            else {
                start = curr;
            }
            curr++;
        }

        return input;
    }

    public static boolean comp() {
        return true;
    }

    public static void main(String args[]) {

    }
}
