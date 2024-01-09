/*
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.



Example 1:


Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:


Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 */

public class BinaryTree_SubTree_Of_AnotherTree_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null || subRoot==null)
            return false;
        if((root.val == subRoot.val) && isSame(root, subRoot)){ //if both roots are same then check if children are also same
            return true;  //if it is false then do not return false, go to next line and check if any child has the tree
        }
        return isSubtree(root.left,  subRoot) || isSubtree(root.right,  subRoot);
    }

    public boolean isSame(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null)
            return true;
        if(root ==null || subRoot ==null)
            return false;
        return (root.val==subRoot.val) && isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }

    public static void main(String[] args) {

        BinaryTree_SubTree_Of_AnotherTree_572 b = new BinaryTree_SubTree_Of_AnotherTree_572();
       /*1.
                       3
                     /   \
                    4     5             4
                  /  \                /   \
                 1    2              1     2
                       \
                       0
         */


        TreeNode n6 = new TreeNode(0, null, null);
        TreeNode n5 = new TreeNode(2, n6, null);
        TreeNode n4 = new TreeNode(1, null, null);
        TreeNode n2 = new TreeNode(4, n4, n5);
        TreeNode n3 = new TreeNode(5, null, null);
        TreeNode n1 = new TreeNode(3, n2, n3);


        TreeNode t3 = new TreeNode(2, null, null);
        TreeNode t2 = new TreeNode(1, null, null);
        TreeNode t1 = new TreeNode(4, t2, t3);

        System.out.println(b.isSubtree(n1, t1)); // false


        BinaryTree_SubTree_Of_AnotherTree_572 b2 = new BinaryTree_SubTree_Of_AnotherTree_572();

        /*2.
                       3
                     /   \
                    4     5             4
                  /  \                /   \
                 1    2              1     2
         */

        TreeNode n11 = new TreeNode(2, null, null);
        TreeNode n10 = new TreeNode(1, null, null);
        TreeNode n9 = new TreeNode(4, n10, n11);
        TreeNode n8 = new TreeNode(5, null, null);
        TreeNode n7 = new TreeNode(3, n9, n8);


        TreeNode t6 = new TreeNode(2, null, null);
        TreeNode t5 = new TreeNode(1, null, null);
        TreeNode t4 = new TreeNode(4, t5, t6);
        System.out.println(b.isSubtree(n7, t4)); // false


         /*3.
                       1
                     /
                    1                  1
         */

        TreeNode n13 = new TreeNode(1);
        n13.left = new TreeNode(1);

        TreeNode t7 = new TreeNode(1);
        System.out.println(b.isSubtree(n13, t7)); // true
    }
}
