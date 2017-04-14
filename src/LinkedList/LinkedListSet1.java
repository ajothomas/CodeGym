package LinkedList;

/**
 * Created by ajothomas on 3/3/17.
 */

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return Integer.toString(this.data);
    }
}

public class LinkedListSet1 {

    static Node insertEnd(Node head, int data) {
        Node temp = head;
        if (temp != null)
            temp = temp.next;
        temp = new Node(data);
        return head;
    }

    static Node insertBeginning(Node head, int data) {
        Node temp = new Node(data);
        if (head != null)
            temp.next = head;
        head = temp;
        return head;
    }

    static Node reverseList(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr.next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        return curr;
    }

    static Node findMiddle(Node head) {
        Node fast = head;
        Node slow = head;

        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static void printList(Node head) {
        Node temp = head;
        System.out.print("\nLinked List :: ");
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
    }

    static Node reverseSecondHalf(Node head) {
        Node middle = findMiddle(head);
        middle.next = reverseList(middle.next);
        return head;
    }

    //Input: 17->15->8->12->10->5->4->1->7->6->NULL
    //Output: 8->12->10->4->6->17->15->5->1->7->NULL
    static Node segregateOddEvenNumbers(Node head) {
        Node last = head, prev = null;
        while (last.next != null)
            last = last.next;

        Node curr = head, temp = null;
        while (curr != null) {
            if (curr.data % 2 == 1) {
                if (curr == head && curr.next != null) {
                    last.next = curr;
                    temp = curr;
                    curr = curr.next;
                    temp.next = null;
                    head = curr;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    last.next = curr;
                    last = last.next;
                }
            } else {
                //
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String args[]) {
        Node head1 = null;
        int arr[] = {1, 3, 5, 7, 9};

        // creating a linked list
        for (int num : arr)
            head1 = insertBeginning(head1, num);

        // printint a list
        printList(head1);

        // reversing a list
        System.out.print("\n*** Reversing a linked list ***");
        head1 = reverseList(head1);
        printList(head1);
        head1 = reverseList(head1);

        //finding the middle of a linked list
        System.out.print("\n*** Finding the middle of linked list ***");
        System.out.print("\nMiddle element : " + findMiddle(head1));

        //reversing second half of a linked list
        System.out.print("\n*** Reversing the second half of linked list ***");
        head1 = reverseSecondHalf(head1);
        printList(head1);
    }
}
