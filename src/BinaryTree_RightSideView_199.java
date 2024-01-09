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

public class BinaryTree_RightSideView_199 {  //BFS - Breadthfirst search


    //Time: O(2n)
    //Space: O(n)
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> answer = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return answer;

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            TreeNode node = queue.peek(); //by the end of below for loop, this has the last node (rightmost)
            for(int i=0; i< size; i++){
                node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            answer.add(node.val); //add the last node to the answer.
        }
        return answer;
    }

    public static void main(String args[]) {

        BinaryTree_RightSideView_199 m = new BinaryTree_RightSideView_199();

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        System.out.println(m.rightSideView(node)); // 3


        BinaryTree_Serialize_Deserialize_297 B = new BinaryTree_Serialize_Deserialize_297();
        TreeNode node2 = B.deserialize("1,2,3,null,5,null,4");

        System.out.println(m.rightSideView(node2)); // 3
    }
}
