/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.



Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.

 */


//Time:O(n)
//Space: O(n) in worst case - if tree is completely unbalanced as each node has only one child
//       O(logn) in best case - if tree is completely balanced and the height of the tree is logN.
public class BinaryTree_Path_has_Sum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;

        if(root.left == null && root.right == null)
            return root.val == targetSum ? true : false;

        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        return left || right;
    }

    public static void main(String[] args){

        BinaryTree_Path_has_Sum_112 b = new BinaryTree_Path_has_Sum_112();
        /*               5
//                   /      \
//                 4         8
//               /         /   \
//              11        13     4
//            /    \              \
//           7      2              1
//
//           5 + 4 + 11 + 2 = 22
         */
        Integer arr1[] = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root1 = new TreeNode();
        root1 = TreeNode.insertLevelOrder(arr1, root1, 0);
        System.out.println(b.hasPathSum(root1,22)); //true


        Integer arr2[] = {1,2,3};
        TreeNode root2 = new TreeNode();
        root2 = TreeNode.insertLevelOrder(arr2, root2, 0);
        System.out.println(b.hasPathSum(root2,5)); //false


        TreeNode root3 = null;
        System.out.println(b.hasPathSum(root3,0)); //false

        Integer arr4[] = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root4 = new TreeNode();
        root4 = TreeNode.insertLevelOrder(arr4, root4, 0);
        System.out.println(b.hasPathSum(root4,26)); //true

        Integer arr5[] = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root5 = new TreeNode();
        root5 = TreeNode.insertLevelOrder(arr5, root5, 0);
        System.out.println(b.hasPathSum(root5,18)); //true
    }
}
