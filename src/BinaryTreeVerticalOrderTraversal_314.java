/*
Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Example 2:


Input: root = [3,9,8,4,0,1,7]
Output: [[4],[9],[3,0,1],[8],[7]]
Example 3:


Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
Output: [[4],[9,5],[3,0,1],[8,2],[7]]


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

import java.util.*;

public class BinaryTreeVerticalOrderTraversal_314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int minCol = 0;
        int maxCol = 0;

        if(root ==null)
            return ans;

        queue.add(root);
        cols.add(0);

        while(!queue.isEmpty()){

            //get node and its col from the queues.
            TreeNode node = queue.poll();
            int col = cols.poll();

            //add val to the corresponding col in map.
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);

            //add left and right children to nodes queue.
            //add left and right children's cols to cols queue.
            if(node.left!=null){
                queue.add(node.left);
                cols.add(col-1);
                minCol = Math.min(minCol, col - 1);
            }

            if(node.right!=null){
                queue.add(node.right);
                cols.add(col+1);
                maxCol = Math.max(maxCol, col + 1);
            }
        }

        //in the increasing order of column get the values.
        for (int i = minCol; i <= maxCol; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}
