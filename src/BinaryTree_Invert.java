/*
Given the root of a binary tree, invert the tree, and return its root.



Example 1:
                 4                                     4
              /     \                               /     \
            2         7                           7         2
         /     \   /     \                     /    \     /    \
        1      3  6       9                  9       6   3       1

Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]


Example 2:
Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

public class BinaryTree_Invert {

    //Time: O(n)
    //Space: O(h), h is height of the tree, in worst case h = n;
    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
