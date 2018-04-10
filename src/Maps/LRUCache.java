package Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ajothomas on 3/16/17.
 */

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class LRUCache {
    Map<Integer, Node> map;
    int size;
    Node head;
    Node tail;

    LRUCache(int size) {
        this.size = size;
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    public void setHead(Node curr) {
        if (head == null) {
            head = curr;
            tail = curr;
        }
        else {
            curr.next = head;
            head.prev = curr;
            head = curr;
        }
    }

    public void remove(Node curr) {
        Node next = curr.next;
        Node prev = curr.prev;

        if(next == null){
            tail = prev;
            tail.next = null;

        }
        else if(prev == null) {
            head = next;
            head.prev = null;
        }
        else {
            prev.next = next;
            next.prev = prev;
        }
        curr.prev = null;
        curr.next = null;
        curr = null;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.data;
        }
        return -1;
    }


    public void set(int data) {
        if (map.containsKey(data)) {
            Node old = map.get(data);

        }
        else {
            Node curr = new Node(data);
            if (map.size() >= size){
                map.remove(tail.data);
                remove(tail);
            }
            setHead(curr);
            map.put(curr.data, curr);
        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LRUCache cacheObject = new LRUCache(5);
        while (true) {
            int input = sc.nextInt();
            System.out.println();
        }
    }
}
