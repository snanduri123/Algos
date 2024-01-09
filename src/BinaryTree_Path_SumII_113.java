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


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time:O(n) in worst case.
//     O(nlogn) in best case : if tree is balanced then each path will be of height logn (so each copy operation into arraylist takes logn) and there will be n/2 paths
//Space: O(n) in worst case - if tree is completely unbalanced as each node has only one child
//       O(logn) in best case - if tree is completely balanced and the height of the tree is logN.
public class BinaryTree_Path_SumII_113 {

    List<List<Integer>> answer;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        answer = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>());
        return answer;

    }

    public void pathSum(TreeNode root, int targetSum, List<Integer> path) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && targetSum == root.val) {
            List<Integer> ans = new ArrayList<>(path);
            ans.add(root.val);
            answer.add(ans);
        }

        path.add(root.val);
        pathSum(root.left, targetSum - root.val, path);
        pathSum(root.right, targetSum - root.val, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        BinaryTree_Path_SumII_113 b = new BinaryTree_Path_SumII_113();
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
        Integer arr1[] = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        TreeNode root1 = new TreeNode();
        root1 = TreeNode.insertLevelOrder(arr1, root1, 0);
        System.out.println(Arrays.deepToString(b.pathSum(root1, 22).toArray())); //[[5, 4, 11, 2]]


        Integer arr2[] = {1, 2, 3};
        TreeNode root2 = new TreeNode();
        root2 = TreeNode.insertLevelOrder(arr2, root2, 0);
        System.out.println(Arrays.deepToString(b.pathSum(root2, 5).toArray())); //[]


        TreeNode root3 = null;
        System.out.println(Arrays.deepToString(b.pathSum(root3, 0).toArray())); //[]

        Integer arr4[] = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}; //TODO: not inserting some values correctly
        TreeNode root4 = new TreeNode(5);
        root4.left = new TreeNode(4);
        root4.right = new TreeNode(8);
        root4.left.left = new TreeNode(11);
        root4.left.left.left = new TreeNode(7);
        root4.left.left.right = new TreeNode(2);
        root4.right.left = new TreeNode(13);
        root4.right.right = new TreeNode(4);
        root4.right.right.right = new TreeNode(1);
        System.out.println(Arrays.deepToString(b.pathSum(root4, 26).toArray())); //5 + 8 + 13

        System.out.println(Arrays.deepToString(b.pathSum(root4, 18).toArray())); //5 + 8 + 4 + 1 = 18
    }
}
