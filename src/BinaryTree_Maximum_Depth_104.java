public class BinaryTree_Maximum_Depth_104 {

    /*
    Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.


     */
    public static void main(String args[]) {

        BinaryTree_Maximum_Depth_104 m = new BinaryTree_Maximum_Depth_104();

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        System.out.println("Depth of binary tree is : " + m.maxDepth(node)); // 3
    }

    /* For recursion
    Time complexity : we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.

    Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only one child node,
    the recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack would be O(N).
    But in the best case (the tree is completely balanced), the height of the tree would be log(N).
    Therefore, the space complexity in this case would be O(log(N)).
    */
    public int maxDepth(TreeNode root) {
        if (root == null) {  // this is helpful in case a node has only one child then in recursion this method will be called for that one child and also null.
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;

        return (left > right) ? left : right;

    }
}
