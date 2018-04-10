package Strings;

/**
 * Created by ajothomas on 11/17/17.
 */
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
public class WordBreakProblem {
        public boolean wordBreak(String s, List<String> wordDict) {
            int strlen = s.length();
            Set<String> wordDictSet = new HashSet<>();
            for(String word: wordDict)
                wordDictSet.add(word);
            boolean T[] = new boolean[strlen];
            for(int i=0; i<strlen; i++) {
                T[i] = false;
            }

            String curr="";

            for(int i=0; i<strlen; i++) {
                curr = s.substring(0,i+1);
                if(T[i]==false && wordDictSet.contains(curr))
                    T[i] = true;

                if(T[i]==true) {
                    if(i==strlen-1)
                        return true;
                    for(int j=i+1; j<strlen; j++) {
                        curr = s.substring(i+1,j+1);
                        if(T[j]==false && wordDictSet.contains(curr))
                            T[j] = true;

                        if(T[j]==true && j==strlen-1)
                            return true;
                    }
                }

            }
            return false;
        }

    public static void main(String args[]) {
        String str = "leetcode";
        List<String> l = new ArrayList<>();
        l.add("leet");
        l.add("code");
        WordBreakProblem wb = new WordBreakProblem();
        System.out.println("Word break : "+wb.wordBreak(str, l));
    }
}
