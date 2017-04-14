package Misc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by ajothomas on 3/18/17.
 */
public class LongestCompoundWord {
    static String longestWord;
    static String secondLongestWord;
    static int totalCount;

    private static boolean checkCompoundWord(String word, TreeMap<String, Integer> wordMAP) {
        if (wordMAP.containsKey(word))
            return true;
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            if (checkCompoundWord(prefix, wordMAP)) {
                String remainder = word.substring(i, word.length());
                if (remainder.length() == 0)
                    return true;
                return checkCompoundWord(remainder, wordMAP);
            }
        }
        return false;
    }

    public static void findCompoundWord(TreeMap<String, Integer> wordMAP) {
        int count = 0;
        int flag = 0;
        while (wordMAP.size() > 0) {
            String word = wordMAP.lastKey();
            wordMAP.remove(word);
            if (checkCompoundWord(word, wordMAP)){
                count++;
                if(flag==1){
                    secondLongestWord = word;
                    flag++;
                }
                if(flag==0){
                    longestWord = word;
                    flag++;
                }
            }
        }

        totalCount = count;
    }

    public static void main(String args[]) throws IOException {
        TreeMap<String, Integer> wordMAP = new TreeMap<String, Integer>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int count=0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/ajothomas/Documents/Code/Java/Aspera/wordsforproblem.txt"));
            String line = br.readLine();

            while (line != null) {
                count++;
                wordMAP.put(line.trim(), count);
                line = br.readLine();
            }
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }

        findCompoundWord(wordMAP);

        System.out.println(longestWord);
        System.out.println(secondLongestWord);
        System.out.println(totalCount);
    }
}
