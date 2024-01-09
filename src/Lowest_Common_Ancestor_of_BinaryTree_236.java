/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
             according to the LCA definition.
Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
 */

//Time -O(n) in worst case. Best case - logn
public class Lowest_Common_Ancestor_of_BinaryTree_236 {

    public static void main(String[] args) {
        Lowest_Common_Ancestor_of_BinaryTree_236 L = new Lowest_Common_Ancestor_of_BinaryTree_236();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(9);

        System.out.println(L.lowestCommonAncestor(root, root.left, root.left.right.right).val); //p=5, q=4 . O/P =5

//        System.out.println(L.lowestCommonAncestor(root,root.left,root.left.right).val); //p=2, q=4 . O/P =2
//
//        TreeNode root2 = new TreeNode(2);
//        root2.left = new TreeNode(1);
//        root2.right = new TreeNode(3);
//
//        System.out.println(L.lowestCommonAncestor(root,root.right,root.left).val); //p=3, q=1 . O/P =2 (Here q < p)
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);
        if(left!=null && right!=null){ //p,q found on each sides of root
            return root;
        }
        if(left!=null) //if left is found then return left itself (claiming p/q is found and so far left itself is LCA. It is possible that both p and q are found by now here or only one of them is found)
            return left;
        if(right!=null) //if right is found then return right itself (claiming p/q is found and so far right itself is LCA. It is possible that both p and q are found by now here or only one of them is found)
            return right;
        return null;   //if none are found then return null;
    }
}
