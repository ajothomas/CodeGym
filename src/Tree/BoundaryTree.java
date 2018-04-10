package Tree;

/**
 * Created by ajothomas on 11/12/17.
 */
public class BoundaryTree {
    public static void inorder (Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+",");
            inorder(root.right);
        }
    }

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

    public static void printLeftSide(Node t1) {
        if(t1==null || t1.left==null)
            return;
        System.out.print(t1.data+", ");
        printLeftSide(t1.left);
    }

    public static void printRightSide(Node t1) {
        if(t1==null || t1.right==null)
            return;
        printRightSide(t1.right);
        System.out.print(t1.data+", ");
    }

    public static void printLastLevel(Node t1) {
        if(t1==null)
            return;
        if(t1.left==null && t1.right==null)
            System.out.print(t1.data+", ");
        printLastLevel(t1.left);
        printLastLevel(t1.right);
    }

    public static void main(String args[]) {

        Node t1 = null;
        int arr1[] = {5, 3, 2, 1, 4, 7, 6, 8};
        for (int i = 0; i < arr1.length; i++)
            t1 = insert(t1, arr1[i]);

        printLeftSide(t1);
        printLastLevel(t1);
        printRightSide(t1.right);
    }

}