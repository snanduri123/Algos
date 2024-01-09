/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.



Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.


Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000

 */


import java.util.List;

//Time:O(n)
//Space: O(n) in worst case - if tree is completely unbalanced as each node has only one child
//       O(logn) in best case - if tree is completely balanced and the height of the tree is logN.
public class BinaryTree_Path_has_Sum_124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int maxSumWithRoot = findMaxPathSum(root);
        return Math.max(maxSum, maxSumWithRoot);
    }

    public int findMaxPathSum(TreeNode root) {

        if(root == null){
            return 0;
        }
        int leftMaxSum = findMaxPathSum( root.left);
        int rightMaxSum =  findMaxPathSum( root.right);

        //maxSum path from this root
        maxSum = Math.max(maxSum, root.val);
        maxSum = Math.max(maxSum, leftMaxSum + root.val);
        maxSum = Math.max(maxSum, rightMaxSum +root.val);
        maxSum = Math.max(maxSum, leftMaxSum + root.val + rightMaxSum);

        //maxSum of (leftpath or right path) with root'value that this root can give to its parent
        int maxInThisTree = Math.max(leftMaxSum, rightMaxSum) + root.val;
        return Math.max(maxInThisTree, root.val);
    }

    public static void main(String[] args) {

        BinaryTree_Path_has_Sum_124 b = new BinaryTree_Path_has_Sum_124();
        /*              9
//                   /     \
//                 6         -3
//                         /    \
//                        -6     2
//                              /
//                             2
//                            /  \
//                          -6    -6
//                          /
//                         -6
//           6 + 9 + -3 + 2 + 2  = 16
         */
        Integer arr1[] = {9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6};


        TreeNode root1 = new TreeNode(9);
        root1.left = new TreeNode(6);
        root1.right = new TreeNode(-3);
        root1.right.left = new TreeNode(-6);
        root1.right.right = new TreeNode(2);
        root1.right.right.left= new TreeNode(2);
        root1.right.right.left.left= new TreeNode(-6);
        root1.right.right.left.right= new TreeNode(-6);
        root1.right.right.left.left.left= new TreeNode(-6);
        System.out.println(b.maxPathSum(root1)); //true
//
//
    }
}
