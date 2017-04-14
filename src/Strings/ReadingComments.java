package src.Strings;
import java.util.Scanner;
/**
 * Created by ajothomas on 3/26/17.
 */
public class ReadingComments {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String outputStr="";
        int multiLineCommentFlag = 0;
        while(sc.hasNext()){
            String input = sc.nextLine();
            if(input.equals("0"))
                break;

            // parsing the string line by line*
            // check for //
            if(input.contains("/*")){
                int position = input.indexOf("/*");
                if(input.contains("*/")){
                    int endposition = input.indexOf("*/");
                    outputStr += input.substring(position+2,endposition).trim()+"\n";
                }
                else {
                    multiLineCommentFlag = 1;
                    outputStr += input.substring(position+2,input.length()).trim()+"\n";
                }
            }
            else if(multiLineCommentFlag==1 && input.contains("*/")){
                outputStr += input.substring(0,input.length()-2).trim()+"\n";
                multiLineCommentFlag=0;
            }
            else if(multiLineCommentFlag==1){
                outputStr += input.trim() + "\n";
            }
            else if(input.contains("//")){
                int position = input.indexOf("//");
                outputStr += input.substring(position+2,input.length()).trim()+"\n";
            }
        }
        System.out.println(outputStr);
    }
}
