/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.



Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.


Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000

 */

import java.util.ArrayList;
import java.util.List;

//Time:O(n)
public class BinaryTree_Sum_Root_To_Leaf_Paths_129 {
    List<String> numStrings;
    public int sumNumbers(TreeNode root) {
        numStrings = new ArrayList<>();
        getRootToLeafPath(root,  "");
        int sum = 0;
        for(String numStr : numStrings){
            sum += Integer.valueOf(numStr);
        }
        return sum;
    }
    public void getRootToLeafPath(TreeNode root, String currNumStr){
        if(root == null){
            return;
        }
        if(root.left == null && root.right ==null){
            numStrings.add(currNumStr + root.val);
            return;
        }
        getRootToLeafPath(root.left,  currNumStr + root.val);
        getRootToLeafPath(root.right, currNumStr + root.val);
    }


    int sum = 0;
    public int sumNumbers2(TreeNode root) {
        findSum( root,  "");
        return sum;
    }

    public void findSum(TreeNode root, String str){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            str = str + root.val;
            sum = sum + Integer.valueOf(str);
            return;
        }
        findSum(root.left,  str + root.val);
        findSum(root.right,  str + root.val);
    }
}
