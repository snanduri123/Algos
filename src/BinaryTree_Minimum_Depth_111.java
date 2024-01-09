public class BinaryTree_Minimum_Depth_111 {

    public static void main(String[] args) {
        BinaryTree_Minimum_Depth_111 m = new BinaryTree_Minimum_Depth_111();

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        System.out.println("Depth of binary tree is : " +  m.minDepth(node)); // 2

        TreeNode node2 = new TreeNode(3);
        node2.left = new TreeNode(9);
        node2.right = new TreeNode(20);
        node2.right.left = new TreeNode(15);
        node2.right.right = new TreeNode(7);

        System.out.println("Depth of binary tree is : " +  m.minDepth(node2)); // 2

    }

    /* For recursion
Time complexity : we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.

Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only one child node,
 the recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack would be O(N).
  But in the best case (the tree is completely balanced), the height of the tree would be log(N).
  Therefore, the space complexity in this case would be O(log(N)).
 */

    public int minDepth(TreeNode root) {
        if (root == null) {  // this is helpful in case a node has only one child then in recursion this method will be called for that one child and also null.
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);


        //+1 is to consider the root node also in the depth
        if (leftDepth == 0)  // if there is no left node then consider only right depth
            return rightDepth + 1;
        else if (rightDepth == 0)
            return leftDepth + 1;  // if there is no right node then consider only left depth
        else
            return leftDepth < rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    //same complexity as above. same code but formatted better
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }

}
