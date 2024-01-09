/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.



Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
 */


//Time:O(n)
//Space: O(n) in worst case - if tree is completely unbalanced as each node has only one child
//       O(logn) in best case - if tree is completely balanced and the height of the tree is logN.
public class BinaryTree_Diameter_543 {   //Bottom up (need global variable and child returns some info to parent)

    int diameter;
    int maxDiameter = 0;

    //Time:O(n)
    //Space: O(n)
    //using DFS
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        depth(root);
        return diameter;
    }

    public int depth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null)  //optional;
            return 1;

        int left = depth(root.left);
        int right = depth(root.right);

        // update the diameter if left_path plus right_path is larger
        diameter = Math.max(diameter, (left + right));

        // return the longest one between left_path and right_path for each side of the current root so that
        // the next parent root can use that path and make it bigger diameter.
        return Math.max(left, right) + 1;

    }


     public Integer binary_tree_diameter(TreeNode root) {
        if(root == null)
        {
            return 0;
        }

        int left = binary_tree_diameter( root.left);
        int right = binary_tree_diameter( root.right);
        int diameter = left + right;
        maxDiameter = Math.max(maxDiameter, diameter);

        return Math.max(left,right) + 1;
    }

    public static void main(String[] args){

        BinaryTree_Diameter_543 b = new BinaryTree_Diameter_543();
 // 1.
//                    1
//                  /   \
//                 2     3
//               /   \
//              4     5
//            /      /
//           8      9
//
//       8, 4, 2, 5, 9 is the longest path and has 5 nodes and 4 edges and does not go through root.

//        Integer arr1[] = {1, 2, 3, 4, 5, null, null, 8, null, 9, null};
//        TreeNode root1 = new TreeNode();
//        root1 = TreeNode.insertLevelOrder(arr1, root1, 0);
//        System.out.println(b.diameterOfBinaryTree(root1)); //4

// 2.
//                       1
//                   /      \
//                 2         3
//               /   \     /   \
//              4     5   6     7
//            /      /    \
//           8      9      12
//         /       /
//        10      11
//
//
//      10, 8, 4, 2, 1, 3, 6, 12 is the longest path and has 8 nodes and 7 edges and does not go through root.
        Integer arr2[] = {1, 2, 3, 4, 5, 6, 7, 8, null, 9, null, null, 12, null, null, 10, null, 11, null};
        TreeNode root2 = new TreeNode();
        root2 = TreeNode.insertLevelOrder(arr2, root2, 0);
        System.out.println(b.diameterOfBinaryTree(root2)); //7

// 3.
        Integer arr3[] = {1,2,3,4,5};
        TreeNode root3 = new TreeNode();
        root3 = TreeNode.insertLevelOrder(arr3, root3, 0);
        System.out.println(b.diameterOfBinaryTree(root3)); //3


    }
}
