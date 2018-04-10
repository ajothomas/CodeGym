package StackQueueHeap;

/**
 * Created by ajothomas on 9/13/17.
 */
class MyQueue {
    int arr[];
    int size, capacity;
    int front, back;
    MyQueue(int capacity) {
        this.size = 0;
        this.arr = new int[capacity];
        this.front = 0;
        this.back = -1;
        this.capacity = capacity;
    }

    boolean isFull() {
        if(this.capacity==this.size) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if(this.capacity==0) {
            return true;
        }
        return false;
    }

    void enqueue(int data) {
        if(isFull()) {
            System.out.println("Queue full..");
            return;
        }
        else {
            this.back = (this.back + 1) % this.capacity;
            this.arr[this.back] = data;
            this.size = this.size + 1;
        }
    }

    int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue empty..");
            return -1;
        }
        else {
            int item = this.arr[this.front];
            this.front = (this.front + 1) % this.capacity;
            this.size = this.size - 1;
            return item;
        }
    }
}

public class QueueImplementation {
    public static void main(String args[]) {
        MyQueue queue = new MyQueue(10);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue() + " dequeued from queue\n");
    }
}
