package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
/**
 * Created by ajothomas on 9/15/17.
 * Given a digit string, return all possible letter combinations that the number could represent.
 */
public class WordsFromPhoneDigits {
    public static void createWords(List<String> final_words, String table[], int numbers[], String curr) {
        if(curr.length() == numbers.length) {
            //System.out.println(curr);
            final_words.add(curr);
            return;
        }
        else {
            int counter = curr.length();
            int num = numbers[counter];
            String str = table[num];
            for(char c:str.toCharArray()) {
                createWords(final_words, table, numbers, curr+c);
            }
        }
    }
    public static void main(String args[]) {
        List<String> final_words = new ArrayList<>();
        String table[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int numbers[] = {2,3};
        createWords(final_words, table, numbers, "");
        System.out.println(Arrays.toString(final_words.toArray()));
    }
}
