package Tree;

/**
 * Created by ajothomas on 11/12/17.
 */
public class CheckSubtree {
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

    public static boolean checkSubtreeUtil(Node t, Node s) {
        if(t==null && s==null)
            return true;
        else if(t==null || s==null)
            return false;
        else
            return ( checkSubtreeUtil(t.left,s.left) && (t.data == s.data) && checkSubtreeUtil(t.right,s.right) );
    }

    public static boolean checkSubtree(Node t, Node s) {
        if(t==null)
            return false;
        if(s==null)
            return true;
        if(checkSubtreeUtil(t,s))
            return true;
        else
            return checkSubtree(t.left,s) || checkSubtree(t.right,s);
    }

    public static void main(String args[]) {

        Node t1 = null;
        Node t2 = null;
        int arr1[] = {5, 3, 2, 1, 4, 6};
        int arr2[] = {3, 2, 1, 4};
        for (int i = 0; i < arr1.length; i++)
            t1 = insert(t1, arr1[i]);
        for (int i = 0; i < arr2.length; i++)
            t2 = insert(t2, arr2[i]);

        System.out.println("Match : "+checkSubtree(t1,t2));
    }

}
