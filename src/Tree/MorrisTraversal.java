package Tree;

import javax.lang.model.type.MirroredTypeException;

/**
 * Created by ajothomas on 11/11/17.
 */
public class MorrisTraversal {
    public static Node insert (Node root, int data) {
        if(root==null){
            root = new Node(data);
        }
        else if(data<root.data)
            root.left = insert(root.left,data);
        else
            root.right = insert(root.right,data);
        return root;
    }

    public static Node MorrisTraversal(Node root) {
        Node curr = root;
        Node newHead = null;
        // making it all right
        Node prev = null;
        Node rightPred = null;

        while(curr!=null) {
            if(curr.left==null) {
                if(newHead==null)
                    newHead = curr;
                System.out.print(curr.data+",");
                rightPred = curr;
                curr = curr.right;
            }
            else {
                prev = curr;
                // go left
                curr = curr.left;
                // find the max
                while(curr.right!=null)
                    curr = curr.right;
                curr.right = prev;

                curr = prev.left;
                prev.left = null;
                if(rightPred!=null)
                rightPred.right = curr;
            }
        }
        return newHead;
    }

    public static void printN(Node n) {
        if(n!=null) {
            System.out.print(n.data+",");
            printN(n.right);
        }
    }

    public static void main(String args[]) {
        Node root = null;
        int arr[] = {5,3,1,2,4,6};
        for(int i=0; i<arr.length; i++){
            root = insert(root, arr[i]);
        }
        Node temp = MorrisTraversal(root);
        System.out.println("::"+temp.data);
        printN(temp);
    }
}
