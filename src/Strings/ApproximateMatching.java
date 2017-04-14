package src.Strings;
import java.util.Scanner;
/**
 * Created by ajothomas on 3/26/17.
 */
public class ApproximateMatching {
    public static int prefixScore(String sub, String prefix){
        int prefixLength = prefix.length();
        for(int i=0;i<prefixLength;i++){
            if(sub.contains(prefix.substring(i)))
                return (prefixLength-i);
        }
        return 0;
    }
    public static String calculateScore(String text, String prefix, String suffix){
        String strMax = "";
        int scoreMax = -999;
        int first=0;
        for(int i=0;i<text.length();i++){
            for(int j=i;j<text.length();j++){
                String sub = text.substring(i,j+1);
                int score = prefixScore(sub,prefix) + prefixScore(suffix, sub);
                if(score >= scoreMax){

                    if(first==0){
                        strMax = sub;
                        scoreMax = score;
                        first=1;
                    }
                    System.out.println("sub:"+sub+", strMax:"+strMax+ "::count:"+sub.compareTo(strMax)+"::"+score);

                    if(score > scoreMax){
                        strMax = sub;
                        scoreMax = score;
                    }
                    else if(sub.compareTo(strMax)<=0 && first==1){
                        strMax = sub;
                        scoreMax = score;
                    }

                }
            }
        }
        return strMax;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String text = sc.next().trim();
        String prefix = sc.next().trim();
        String suffix = sc.next().trim();
        System.out.println(calculateScore(text,prefix,suffix));
    }
}
