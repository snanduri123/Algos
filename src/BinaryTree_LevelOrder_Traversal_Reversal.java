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

import java.util.*;

public class BinaryTree_LevelOrder_Traversal_Reversal {  //BFS - Breadthfirst search


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> answer = new LinkedList<List<Integer>>();

        if(root == null) return answer;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
                subList.add(node.val);
            }
            answer.add(subList);
        }
        Collections.reverse(answer);
        return answer;
    }


    public static void main(String[] args) {

        BinaryTree_LevelOrder_Traversal_Reversal b = new BinaryTree_LevelOrder_Traversal_Reversal();
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
        System.out.println(b.levelOrder(root1)); //true
    }

}
