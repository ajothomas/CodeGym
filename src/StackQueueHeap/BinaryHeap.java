package StackQueueHeap;

import java.util.Arrays;

/**
 * Created by ajothomas on 9/17/17.
 */

public class BinaryHeap {
    int capacity;
    int heapSize;
    int arr[];

    BinaryHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity+1];
        this.heapSize = 0;
        Arrays.fill(arr, -1);
    }

    // check if heap is empty
    public boolean isEmpty() {
        return heapSize==0;
    }

    // check if heap is full
    public boolean isFull() {
        return heapSize==capacity;
    }

    // clear heap
    public void makeEmpty() {
        heapSize = 0;
        Arrays.fill(arr, -1);
    }

    // function to insert
    public void insert(int x) {
        if(isFull()) {
            System.out.println("Heap full");
            return;
        }
        else {
            arr[++heapSize] = x;
            percolateUp();
        }
    }

    public void deleteMin() {
        if(isEmpty()) {
            System.out.println("Heap empty");
            return;
        }
        else {
            arr[1] = arr[heapSize];
            arr[heapSize--] = -1;
            percolateDown(1);
        }
    }

    public void percolateUp() {
        int i = heapSize;
        int c = arr[heapSize];
        for(;arr[i/2]>c && i>=1;i=i/2) {
            arr[i] = arr[i/2];
        }
        arr[i] = c;
    }

    public void percolateDown(int index) {
        int i = index;
        int c = arr[index];
        while(i<=heapSize) {
            int child1index = ((i*2)<=heapSize)?(i*2):-1;
            int child2index = ((i*2+1)<=heapSize)?(i*2+1):-1;
            if(child1index == -1 && child2index==-1) {
                break;
            }
            else if(child1index != -1) {
                arr[i] = arr[child1index];
                i = child1index;
            }
            else if(child2index != -1) {
                arr[i] = arr[child2index];
                i = child2index;
            }
            else {
                int childIndex = (arr[child1index]>arr[child2index])?(i*2+1):(i*2);
                arr[i] = arr[childIndex];
                i = childIndex;
            }
        }
        arr[i] = c;
    }

    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 1; i <= heapSize; i++)
            System.out.print(arr[i] +" ");
        System.out.println();
    }

    public static void main(String args[]) {
        BinaryHeap bh = new BinaryHeap(10);
        int arr[] = {6,7,12,10,15,17};
        for(int x:arr) {
            bh.insert(x);
        }
        bh.insert(5);
        bh.printHeap();
        bh.deleteMin();
        bh.printHeap();
    }
}
