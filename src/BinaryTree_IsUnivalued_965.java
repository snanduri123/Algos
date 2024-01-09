///*
//A binary tree is uni-valued if every node in the tree has the same value.
//
//Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
//
//
//
//Example 1:
////
////                1             - 1st level
////              /  \
////            1      1           - 2nd level
////           / \    / \
////          1   1   1  1         -3rd level
//
//Input: root = [1,1,1,1,1,null,1]
//Output: true
//
//
//Example 2:
////                2             - 1st level
////              /  \
////            2      2           - 2nd level
////           / \    / \
////          5   2   2  2         -3rd level
//
//Input: root = [2,2,2,5,2]
//Output: false
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 100].
//0 <= Node.val < 100
// */
//
//public class BinaryTree_IsUnivalued_965 {
//
//    int val;
//
//    public boolean isUnivalTree(TreeNode root) {
//        //   if(root == null)
//        //       return false;
//
//        val = root.val;
//
//        return isUnivalTree(root, val);
//    }
//
//    public boolean isUnivalTree(TreeNode root, int val) {
//
//        if (root == null)
//            return true;
//
//        if (root.left == null && root.right == null && root.val == val)
//            return true;
//
//        return (isUnivalTree(root.left, root.val) &&
//                isUnivalTree(root.right, root.val));
//
//    }
//
//    BinaryTree_IsUnivalued_965 L = new BinaryTree_IsUnivalued_965();
//    //1
//    TreeNode root = new TreeNode(1);
//    root.left =new
//
//    TreeNode(4);
//
//    root.left.left =new
//
//    TreeNode(4);
//
//    root.left.right =new
//
//    TreeNode(4);
//
//    root.right =new
//
//    TreeNode(5);
//
//    root.right.left =new
//
//    TreeNode(5);
//
//
//        System.out.println(L.longestUnivaluePath(root)); //2
//}
//}
