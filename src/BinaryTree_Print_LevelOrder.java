/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Example 1:
             3
          /   \
         9     20
              /  \
             15  7

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree_Print_LevelOrder {

    //This is standard bfs template
    //Time : O(n)
    //Space: O(n)
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> answer = new LinkedList<List<Integer>>();

        if (root == null) return;

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);

            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    public static void main(String args[]) {

        BinaryTree_Print_LevelOrder m = new BinaryTree_Print_LevelOrder();

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

         m.bfs(node); // 3
    }
}
