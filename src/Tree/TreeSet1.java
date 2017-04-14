/**
 * Created by ajothomas on 3/4/17.
 */

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString(){
        return Integer.toString(this.data);
    }
}

class TreeNode_1 {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode_1(int data){
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

public class TreeSet1 {

    static TreeNode insert(TreeNode root, int data){
        if(root!=null){
            if(data < root.data)
                root.left = insert(root.left, data);
            else if(data > root.data)
                root.right = insert(root.right, data);
        }
        else
            root = new TreeNode(data);
        return root;
    }

    static void inorderTraversal(TreeNode root){
        if(root!=null){
            inorderTraversal(root.left);
            System.out.print(root+", ");
            inorderTraversal(root.right);
        }
    }

    // smallest element in a tree
    static TreeNode findSmallest(TreeNode root) {
        TreeNode temp = root;
        while(temp.left!=null)
            temp = temp.left;

        return temp;
    }

    // finding a node in tree
    static TreeNode findNode(TreeNode root, int element) {
        if(element<root.data)
            return findNode(root.left, element);
        else if(element>root.data)
            return findNode(root.right, element);
        else
            return root;
    }

    // find the inorder successor
    static TreeNode inorderSuccessor(TreeNode root, int element) {
        TreeNode node = findNode(root, element);
        if(node.right!=null)
            return findSmallest(root.right);

        TreeNode head = root;
        TreeNode successor = null;
        while(head!=null) {
            if(element<head.data){
                successor = head;
                head = head.left;
            }
            else if(element>head.data)
                head = head.right;
            else
                break;
        }

        return successor;
    }

    static void kthSmallest(TreeNode root, int k, int curr){
        if(root!=null) {
            kthSmallest(root.left, k, curr);

            curr++;
            if(curr==k)
                System.out.println("\nK th smallest : "+curr);

            kthSmallest(root.right, k, curr);
        }
    }

    static void mirrorTree(TreeNode root){
        if(root!=null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            mirrorTree(root.left);
            mirrorTree(root.right);
        }
    }

    static void LCA(TreeNode root, int data1, int data2){
        if(root!=null){
            if(data1<root.data && data2<root.data)
                LCA(root.left, data1, data2);
            else if(data1>root.data && data2>root.data)
                LCA(root.right, data1, data2);
            else
                System.out.println("\nLCA is : "+root.data);
        }
    }

    public static void main(String args[]){
        TreeNode root = null;

        // inserting
        int arr[] = {5,3,4,2,1,7,6,8,9};
        for(int element:arr)
            root = insert(root, element);

        //inorder traversal
        System.out.println("** INORDER TRAVERSAL **");
        inorderTraversal(root);

        //LCA
        LCA(root,4,2);

        //Kth smallest element
        kthSmallest(root, 3, 0);

        //Find smallest
        System.out.print("\nSmallest Element : "+findSmallest(root));

        //Find node
        System.out.print("\nFound Element : "+findNode(root, 3));

        //Inorder successor
        System.out.print("\nInorder successor : "+inorderSuccessor(root,4));

        //mirror tree
        System.out.println("\n\n** MIRRORING TREE **");
        System.out.println("- BEFORE MIRRORING -");
        inorderTraversal(root);
        mirrorTree(root);
        System.out.println("\n- AFTER MIRRORING -");
        inorderTraversal(root);

    }
}
