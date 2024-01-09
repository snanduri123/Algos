//import apple.laf.JRSUIUtils;

import java.util.ArrayList;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }

    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(){
        this.val = val;
    }

    // Function to insert nodes in level order
    public static TreeNode insertLevelOrder(Integer[] arr, TreeNode root,
                                 int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            if(arr[i] != null) {
                TreeNode temp = new TreeNode(arr[i]);
                root = temp;

                // insert left child
                root.left = insertLevelOrder(arr, root.left,
                        2 * i + 1);

                // insert right child
                root.right = insertLevelOrder(arr, root.right,
                        2 * i + 2);
            }
        }
        return root;
    }

    // Function to print tree nodes in InOrder fashion
    public static void inOrder(TreeNode root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

}
