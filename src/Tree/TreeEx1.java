package Tree;
import java.util.ArrayList;
import java.util.jar.Pack200;

/**
 * Created by ajothomas on 3/19/17.
 */

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class TreeEx1 {

    public static void inorder (Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+",");
            inorder(root.right);
        }
    }

    public static Node insert (Node root, int data){
        if(root==null){
            root = new Node(data);
        }
        else if(data<root.data)
            root.left = insert(root.left,data);
        else
            root.right = insert(root.right,data);
        return root;
    }

    public static Node LCA (Node root, int data1, int data2){
        if(root!=null){
            if(data1<root.data && data2<root.data)
                return LCA(root.left, data1, data2);
            else if(data1>root.data && data2>root.data)
                return LCA(root.right, data1, data2);
            else
                return root;

        }
        return null;
    }


/*
    public static Node delete(Node root, int data){
        if(data<root.data)
            root.left = delete(root.left, data);
        else if(data>root.data)
            root.right = delete(root.right, data);
        else {
            if(root.left==null && root.right==null){
                root = null;
            }
            else if(root.left==null){
                root.data = root.right.data;
                root.right = null;
            }
            else if(root.right==null){
                root.data = root.left.data;
                root.left = null;
            }
            else {
                Node minNode = findMin(root.right);
                root.data = minNode.data;
                root.right = delete(root.right, minNode.data);
            }
        }

        return root;
    }*/

    public static void mirror (Node root){
        if(root!=null){
            mirror(root.left);
            mirror(root.right);
            Node temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
    }

    public static int height(Node root){
        if(root!=null)
            return Math.max(height(root.left), height(root.left))+1;
        return 0;
    }

    public static int distance(Node root, int level, int data){
        if(root!=null){
            if(root.data == data)
                return level;
            distance(root.left, level+1, data);
            distance(root.right, level+1, data);
        }
        return 0;
    }


    public static void maxAtEveryLevel(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        maxAtEveryLevelDriver(arr, 0, root);
        int i=0;
        for (int element : arr) {
            System.out.println("Level "+(i++)+" : "+element);
        }
    }
    public static void maxAtEveryLevelDriver(ArrayList<Integer> arr, int depth,Node root){
        if(root==null)
           return;
        if((depth+1)<=arr.size())
            arr.add(depth,Math.max(root.data, arr.get(depth)));
        else
            arr.add(depth,root.data);
        maxAtEveryLevelDriver(arr, depth+1,root.left);
        maxAtEveryLevelDriver(arr, depth+1,root.right);

    }

    public static int diameter(Node root) {
        if(root!=null){
            int leftHeight = height(root.left);
            int rightHeight = height(root.left);
            int leftDiameter = diameter(root.left);
            int rightDiameter = diameter(root.right);
            return Math.max(leftHeight+rightHeight+1, Math.max(leftDiameter,rightDiameter));
        }
        return 0;
    }

    public static void serialization(Node root) {
        if(root!=null){
            System.out.print(root.data+", ");
            serialization(root.left);
            serialization(root.right);
        }
        System.out.print("-1, ");
        return;
    }


    public static void main(String args[]){

        Node root = null;
        //int arr[] = {5,3,2,1,4,7,6,8,9};
        //int arr[] = {5,6,3,1,2,4};
        int arr[] = {5,3,1,2,4,6};
        for(int i=0; i<arr.length; i++){
            root = insert(root, arr[i]);
        }

        // print tree
        System.out.print("\n** INORDER TRAVERSAL **\n");

        inorder(root);

        // preorder/serialization
        System.out.print("\n** INORDER TRAVERSAL **\n");

        serialization(root);

        //root = delete(root, 5);
        System.out.print("\n** INORDER TRAVERSAL **\n");
        inorder(root);

        System.out.print("\n** DISTANCE **\n");
        Node lca = LCA(root, 5,6);
        System.out.print("\nVal of LCA : "+lca.data);
        System.out.print("\nDistance of node : "+distance(root, 1, 2));
        // mirror tree
        System.out.print("\n** MIRRORED TREE **\n");
        mirror(root);
        inorder(root);
        mirror(root);

        //height
        System.out.print("\n** HEIGHT OF TREE **\n");
        System.out.print(height(root));

        //height
        System.out.print("\n** Diameter OF TREE **\n");
        System.out.print(diameter(root));

        //height
        System.out.print("\n** Max at every level of tree **\n");
        maxAtEveryLevel(root);

    }
}
