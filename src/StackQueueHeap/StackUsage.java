package src.StackQueueHeap;
import java.util.Stack;
/**
 * Created by ajothomas on 3/21/17.
 */
public class StackUsage {
    public static void main(String args[]){
        int arr[]={1,3,4,5,6};
        Stack st = new Stack();
        for(int element:arr)
            st.push(element);
        System.out.println("Stack : "+st);
        System.out.println("Top most element : "+st.peek());
    }
}
