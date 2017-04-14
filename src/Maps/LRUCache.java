package Maps;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ajothomas on 3/16/17.
 */
/*

class Node{
    int value;
    Node next;
    Node prev;

    Node(int value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCacheStruct {
    int cacheSize;
    HashMap cacheMap;
    Node head;
    Node tail;

    LRUCacheStruct(int cacheSize){
        this.cacheSize = cacheSize;
        cacheMap = new HashMap<Integer,Node>();
        this.head = null;
        this.tail = null;
    }

    void set(int value){
       if(!cacheMap.containsKey(value)){
           if(cacheSize == cacheMap.size()){
               Node temp = new Node(value);
               temp.next = head;
               temp.prev = null;

               head.prev = temp;
               head = temp;
               cacheMap.put(value, head);

               Node temp2 = tail.prev;

               temp2.next = null;
               tail.prev = null;
               cacheMap.remove(tail.value);
               tail = temp2;
           }
           else {
               Node temp = new Node(value);
               temp.next = head;
               temp.prev = null;

               head.prev = temp;
               head = temp;
               cacheMap.put(value, head);
           }

       }
    }

    int get(int value){
        if(cacheMap.containsKey(value)){
            Node temp = (Node)cacheMap.get(value);
            if(temp==head)
                return value;
            if(temp==tail){
                Node prevNode = temp.prev;
                prevNode.next = null;

                temp.prev = null;
                temp.next = head;
                head.prev = temp;
                head = temp;
                return value;
            }

            Node prevNode = temp.prev;
            Node nextNode = temp.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            temp.prev = null;
            temp.next = head;
            head.prev = temp;
            head = temp;

            return value;
        }
        else
            return -1;
    }
}
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
    HashMap<Integer, Node> map;
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
