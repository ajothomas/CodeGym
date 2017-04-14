package src.Strings;

/**
 * Created by ajothomas on 3/26/17.
 */
import java.util.HashMap;
public class String_Set2 {

    public static String lengthOfLongestSubstringTwoDistinct(String s, int k) {
        int max=0;
        int finalStart=0;

        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int start=0;
        int i=0;
        for(; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }

            if(map.size()>2){
                if(i-start>max) {
                    max = i - start;
                    finalStart = start;
                }
                while(map.size()>k){
                    char t = s.charAt(start);
                    int count = map.get(t);
                    if(count>1){
                        map.put(t, count-1);
                    }else{
                        map.remove(t);
                    }
                    start++;
                }
            }
        }

        if(i-start>max) {
            max = i - start;
            finalStart = start;
        }

        return s.substring(finalStart,start+max);
    }
    public static void main(String args[]){
        System.out.println(lengthOfLongestSubstringTwoDistinct("aababaaacacaccccadefab",2));
    }
}
