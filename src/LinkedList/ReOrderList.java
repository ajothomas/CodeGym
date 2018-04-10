package LinkedList;

/**
 * Created by ajothomas on 11/4/17.
 */
/*
* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
* reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
* */
public class ReOrderList {
    static Node insertEnd(Node head, int data) {
        Node temp = head;
        if (temp == null) {
            head = new Node(data);
            return head;
        }
        while(temp.next!=null)
            temp = temp.next;
        temp.next = new Node(data);
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        System.out.print("\nLinked List :: ");
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
    }

    static Node reOrder(Node head) {
        return head;
    }

    static Node middle(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr.next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        return curr;
    }


    public static void main(String args[]) {
        Node l1 = null;
        for(int i=0;i<10;i++) {
            l1 = insertEnd(l1,i+1);
        }

        printList(l1);
        Node mid = middle(l1);
        System.out.println("\nMiddle element is : "+mid.data);
        mid.next = reverse(mid.next);
        printList(l1);

        Node x1 = l1;
        Node x2 = mid.next;
        mid.next = null;

        while(x2!=null) {
            Node temp1 = x1.next;
            Node temp2 = x2.next;

            x1.next = x2;
            x2.next = temp1;
            x1 = temp1;
            x2 = temp2;
        }

        printList(l1);
    }
}
