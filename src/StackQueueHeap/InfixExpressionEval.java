package StackQueueHeap;

import java.util.Stack;

/**
 * Created by ajothomas on 9/26/17.
 */
public class InfixExpressionEval {

    public static void main(String args[]) {
        String expression = "100 * ( 2 + 12 ) / 14";
        String expressionArr[] = expression.split(" ");

        Stack<String> valueST = new Stack<>();
        Stack<String> operatorST = new Stack<>();

        for(String token:expressionArr) {
            if(token.charAt(0)>=48 && token.charAt(0)<=57) {

            }
        }
    }
}
