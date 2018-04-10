package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajothomas on 12/4/17.
 */
public class MissingWords {
    public String[] solve(String s1, String s2) {
        List<String> ans = new ArrayList<>();
        String[] s1arr = s1.split(" ");
        String[] s2arr = s2.split(" ");
        int i=0, j=0;
        while(i<s1arr.length && j<s2arr.length) {
            if(s1arr[i].equals(s2arr[j])) {
                i++;
                j++;
            }
            else
                ans.add(s1arr[i++]);
        }
        while(i<s1arr.length)
            ans.add(s1arr[i++]);
        String[] strarray = new String[ans.size()];
        ans.toArray(strarray);
        return strarray;
    }
    public static void main(String args[]) {
        String s1 = "I am using hackerrank to improve programming";
        String s2 = "am hackerrank to improve";
        MissingWords s = new MissingWords();
        for(String st:s.solve(s1, s2)) {
            System.out.println(st);
        }
    }
}
