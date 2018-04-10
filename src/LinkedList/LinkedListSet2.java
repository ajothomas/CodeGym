package LinkedList;

/**
 * Created by ajothomas on 9/18/17.
 */
public class LinkedListSet2 {
    // Insert an element in the beginning of a linked list
    static Node insertFront(Node head, int data) {
        Node temp = new Node(data);
        if (head != null)
            temp.next = head;
        head = temp;
        return head;
    }

    public static Node intersection(Node head1, Node head2) {
        if(head1==null || head2==null)
            return null;

        if(head1.data<head2.data)
            return intersection(head1.next, head2);
        else if(head1.data>head2.data)
            return intersection(head1, head2.next);
        else {
            Node temp = new Node(head1.data);
            temp.next = intersection(head1.next, head2.next);
            return temp;
        }
    }

    static void printList(Node head) {
        Node temp = head;
        System.out.print("\nLinked List :: ");
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
    }

    public static void main(String args[]) {
        Node head1 = null, head2 = null;
        int arr1[] = {5,4,3,2,1};
        int arr2[] = {4,2};

        for(int x:arr1)
            head1 = insertFront(head1, x);
        for(int x:arr2)
            head2 = insertFront(head2, x);

        Node head3 = intersection(head1, head2);
        printList(head1);
        printList(head2);
        printList(head3);
    }
}

