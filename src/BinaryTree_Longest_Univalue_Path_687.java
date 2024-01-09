/*
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output: 2


3.

               1
             /  \
            4    5
           / \   /
          4   4 5

  Output: 2
Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

*/
public class BinaryTree_Longest_Univalue_Path_687 {
    int max;

    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        longestPath(root);
        return max;
    }

    public int longestPath(TreeNode node) {
        // Base case: if null node, return 0
        if (node == null) {
            return 0;
        }
        // Get the max length from left and right
        int maxLeft = longestPath(node.left);
        int maxRight = longestPath(node.right);

        // Calculate the current max length
        int maxLeftSoFar = 0;
        int maxRightSoFar = 0;

        // Compare parent node with child node
        // If they are the same, extend the max length by one
        if (node.left != null && node.left.val == node.val) {
            maxLeftSoFar = maxLeft + 1;
        }
        if(node.right != null && node.right.val == node.val) {
            maxRightSoFar = maxRight + 1;
        }
        // Update the max with the sum of left and right length
        max = Math.max(max, maxLeftSoFar + maxRightSoFar);

        // Return the max from left and right to upper node
        // since only one side path is valid
//        Eg:
//             1             - 1st level
//              \
//               1           - 2nd level
//                \
//                 1         -3rd level
//               /   \
//              1     1      -4th level
//             /
//            1

        //Here there are two paths -
//                1
//                \
//                 1
//               /
//              1
//             /
//            1

//       and
//               1
//                \
//                 1
//                   \
//                    1

//   At third level the longest past is 3 but to calucalate the longest path from second level - one of the longest sides (either left or right) should be sent upward
//   so that path is unidirectional
//             1             - 1st level
//              \
//               1           - 2nd level
//                \
//                 1         - 3rd level
//               /
//              1
//             /
//            1


        return Math.max(maxLeftSoFar,maxRightSoFar);
    }


    public static void main(String[] args) {
        BinaryTree_Longest_Univalue_Path_687 L = new BinaryTree_Longest_Univalue_Path_687();
        //1
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(4);
//
//        root.right = new TreeNode(5);
//        root.right.left = new TreeNode(5);
//
//
//        System.out.println(L.longestUnivaluePath(root)); //2


        //2
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(1);
//
//        root.left.left.left = new TreeNode(1);
//        root.left.left.right = new TreeNode(1);
//        root.left.left.right.right = new TreeNode(1);
//        root.left.left.left.left = new TreeNode(1);
//
//        root.right = new TreeNode(5);
//        root.right.right = new TreeNode(5);
//
//
//        System.out.println(L.longestUnivaluePath(root)); //4

        //3

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(4);
        root.left.right.left.left = new TreeNode(4);
        root.left.right.left.left.left = new TreeNode(4);
        root.left.right.left.left.left.left = new TreeNode(4);
        root.left.right.left.left.left.left.left = new TreeNode(4);

        System.out.println(L.longestUnivaluePath(root)); //4


    }
}
