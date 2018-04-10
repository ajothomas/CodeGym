package LinkedList;

/**
 * Created by ajothomas on 9/18/17.
 */
public class MergeSort {
    // Insert an element in the beginning of a linked list
    static Node insertRear(Node head, int data) {
        if(head==null)
            head = new Node(data);
        else {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = new Node(data);

        }
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

    public static Node mergeLists(Node head1, Node head2) {
        Node temp = null;
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        if(head1.data<head2.data) {
            temp = head1;
            temp.next = mergeLists(head1.next, head2);
        }
        else {
            temp = head2;
            temp.next = mergeLists(head1, head2.next);
        }
        return temp;
    }

    public static Node middle(Node head) {
        Node fast = head;
        Node slow = head;
        while(slow!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node mergeSort(Node head) {
        if(head.next==null)
            return head;
        else {
            Node temp = head;
            Node middle = middle(temp);
            Node middleNext = middle.next;
            middle.next = null;

            Node part1 = mergeSort(temp);
            Node part2 = mergeSort(middleNext);
            return mergeLists(part1, part2);
        }
    }

    public static void main(String args[]) {
        Node head = null;
        int arr[] = {6,5,4,3,2,1};
        for(int x:arr) {
            head = insertRear(head, x);
        }
        printList(head);
        //Node head1 = mergeSort(head);
        Node temp = middle(head);
        System.out.print(temp.data);
        //printList(head1);
    }
}
