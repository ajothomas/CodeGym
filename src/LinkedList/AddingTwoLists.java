package LinkedList;

/**
 * Created by ajothomas on 11/5/17.
 */
public class AddingTwoLists {
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

    static int listLength(Node head) {
        Node temp = head;
        int count=0;
        while(temp!=null) {
            temp = temp.next;
            count++;
        }

        return count;
    }

    static Node addListsFunc(Node l1, Node l2) {
        if(l1==null || l2==null)
            return null;
        else {
            int carry = 0;
            Node next = addListsFunc(l1.next, l2.next);
            if(next!=null)
                carry = next.data%9;
            Node curr = addListsFunc(l1, l2);
            curr.data = curr.data + carry;
            return curr;
        }
    }
    
    static Node addLists(Node l1, Node l2) {
        int len1 = listLength(l1);
        int len2 = listLength(l2);
        if(len2>len1) {

            Node temp = l2;
            l2 = l1;
            l1 = temp;
        }
        else if(len1==len2) {
            return addListsFunc(l1,l2);
        }
        int diff = Math.abs(len1-len2);
        int count = 0;
        Node l11 = l1;
        while(count<=diff)
            l11 = l11.next;

        l1.next = addListsFunc(l11,l2);

        return l1;
    }

    public static void main(String args[]) {
        Node l1 = null;
        Node l2 = null;
        int list1[] = {5,0,7,3};
        int list2[] = {3,7};
        for(int num:list1)
            l1 = insertEnd(l1,num);
        for(int num:list2)
            l2 = insertEnd(l2,num);

        Node l3 = addLists(l1,l2);
    }
}
