package Amazon;

import java.util.HashMap;

/**
 * Created by ajothomas on 9/17/17.
 */

class LRUNode {
    int key;
    int value;
    LRUNode next;
    LRUNode prev;

    LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
public class LRUCache {
    LRUNode head = null, end = null;
    int capacity;
    HashMap<Integer, LRUNode> map = new HashMap<>();

    LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void remove(LRUNode curr) {
        LRUNode prev = curr.prev;
        LRUNode next = curr.next;

        // current element is head
        if(prev!=null)
            prev.next = next;
        else
            head = next;

        // current element is end
        if(next!=null)
            next.prev = prev;
        else
            end = prev;
    }

    public void setHead(LRUNode curr) {
        curr.next = head;
        if(head!=null)
            head.prev = curr;

        head = curr;
        if(end==null)
            end = head;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            LRUNode oldNode = map.get(key);
            oldNode.value = value;
            remove(oldNode);
            setHead(oldNode);
        }
        else{
            LRUNode newNode = new LRUNode(key, value);
            if(map.size()==capacity) {
                remove(end);
            }
            map.put(key, newNode);
            setHead(newNode);
        }
    }


    public static void main(String args[]) {

    }
}
