package LinkedList;

/**
 * Created by ajothomas on 9/16/17.
 */
class DNode {
    int data;
    DNode next;
    DNode prev;

    DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    public static DNode insertFront(DNode head, int data) {
        DNode temp = new DNode(data);
        if(head!=null) {
            temp.next = head;
            head.prev = temp;
        }
        head = temp;
        return head;
    }

    public static DNode delete(DNode head, int data) {
        DNode A=null, B=null, C=null;
        B = head;

        while(B!=null) {
            C = B.next;
            if(B.data == data) {
                // if first node
                if(B==head) {
                    C.prev = null;
                    head = C;
                } else { // any other nodes
                    A.next = B.next;
                    if(C!=null) {
                        C.prev = A;
                    }
                }
                break;
            }
            A = B;
            B = C;
        }
        return head;
    }

    public static DNode reverse(DNode head) {
        DNode prev = null, next = null;
        DNode curr = head;

        while(curr.next!=null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        curr.prev = null;
        return curr;
    }

    public static void printDList(DNode head) {
        DNode temp = head;
        while(temp!=null) {
            System.out.print(temp.data+", ");
            temp = temp.next;
        }

    }

    public static void main(String args[]) {
        DNode head = null;
        int arr[] = {1,2,3,4,5,6,7,8};

        for(int x:arr) {
            head = insertFront(head, x);
        }
        printDList(head);
        System.out.print("\nReversed : ");
        DNode head1 = reverse(head);
        printDList(head1);
    }
}
