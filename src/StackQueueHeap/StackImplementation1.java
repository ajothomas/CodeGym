package src.StackQueueHeap;

/**
 * Created by ajothomas on 3/21/17.
 */

class MyStack {
    int arr[];
    int size;
    int topOfStack;

    MyStack(int size){
        this.arr = new int[size];
        this.size = size;
        this.topOfStack = -1;
    }

    void push(int data){
        if(topOfStack==size){
            System.out.println("Stack full");
        }
        else {
            arr[topOfStack++] = data;
        }
    }

    int pop(){
        if(topOfStack==-1){
            System.out.println("Stack empty");
            return -1;
        }
        return arr[topOfStack--];
    }
}
public class StackImplementation1 {

}
