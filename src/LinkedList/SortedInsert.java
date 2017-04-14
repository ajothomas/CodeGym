package LinkedList;

/**
 * Created by ajothomas on 4/14/17.
 */
public class SortedInsert {
    Node head;

    SortedInsert() {
        this.head = null;
    }

    void printList() {
        Node current = head;
        while (current.next != head) {
            System.out.print(current.data + ",");
            current = current.next;
        }
        System.out.print(current.data);
    }

    void sortedInsertFunction(int data) {
        Node current = head;

        if (current == null) {
            head = new Node(data);
            head.next = head;
        }

        else if (head.data >= data) {
            while (current.next != head)
                current = current.next;

            Node newNode = new Node(data);
            current.next = newNode;
            newNode.next = head;
            head = newNode;
        } else if (head.data < data){
            while (current.next != head && data > current.next.data)
                current = current.next;

            Node newNode = new Node(data);
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public static void main(String args[]) {
        SortedInsert obj = new SortedInsert();

        int arr[] = new int[]{12, 56, 2, 11, 1, 90};
        for (int i = 0; i < arr.length; i++) {
            obj.sortedInsertFunction(arr[i]);
        }

        obj.printList();
    }
}
