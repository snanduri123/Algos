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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree_Average_Of_Levels_637 {  //BFS - Breadthfirst search

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> avgAnswer = new ArrayList<Double>();

        if(root == null) return avgAnswer;

        queue.offer(root);

        while(!queue.isEmpty()){
            Integer numOfNodesInThisLevel = queue.size();
            Double sum = Double.valueOf(0);
            Double avg = Double.valueOf(0);

            for(Integer i=0; i<numOfNodesInThisLevel; i++) {
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.offer(node.left); //
                if(node.right != null)
                    queue.offer(node.right);
                sum = sum + node.val;
            }
            avg = sum/numOfNodesInThisLevel;
            avgAnswer.add(avg);
        }
        return avgAnswer;
    }
}
