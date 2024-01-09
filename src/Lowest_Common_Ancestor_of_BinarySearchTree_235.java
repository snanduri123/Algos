/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
             according to the LCA definition.
Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the BST.

 */
public class Lowest_Common_Ancestor_of_BinarySearchTree_235 {

    public static void main(String[] args){
        Lowest_Common_Ancestor_of_BinarySearchTree_235 L = new Lowest_Common_Ancestor_of_BinarySearchTree_235();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(L.lowestCommonAncestor(root,root.left,root.right).val); //p=2, q=8 . O/P =6

        System.out.println(L.lowestCommonAncestor(root,root.left,root.left.right).val); //p=2, q=4 . O/P =2

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        System.out.println(L.lowestCommonAncestor(root,root.right,root.left).val); //p=3, q=1 . O/P =2 (Here q < p)

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(root == null)
        //     return null;
        if((root.val> p.val) && (root.val > q.val)) //both are smaller than root
            return lowestCommonAncestor( root.left,  p,  q);

        if((root.val < p.val) && (root.val < q.val)) //both are greater than root
            return lowestCommonAncestor( root.right,  p,  q);

        return root;  //1. one is on left and one is on right or 2. one/both of them are equal to root.
    }
}
