/*
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.



Example 1:


Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]


Constraints:

1 <= n <= 8
 */


import java.util.ArrayList;
import java.util.List;


/*
For n = 3, -->  1,2,3
start  = 1 ; end = 3
i as a root iterates from 1 to 3.

So when i is 1, with 1 as root,
there can be no left trees formed because there are no nodes on left side and
there are two options for right trees as below
             1                  1
           /   \              /    \
        null     2          null    3
                  \                /
                   3              2

when i= 2 there is only 1 left tree with single node (1) and 1 right tree with single node (3)
                        2
                     /     \
                    1       3

when i= 3 there are two options for left trees and no option on right side
             3                 3
           /   \              /  \
          1     null         2   null
           \                /
            2              1
  So there are total 5 trees for n = 3
 */
public class BinarySearchTree_Recur_Unique_BSTs_II_95 {

    public List<TreeNode> generateTrees(int n) {
        return generateTrees( 1,  n);
    }

    public List<TreeNode> generateTrees(int start, int end) {

        List<TreeNode> trees = new ArrayList<>();
        /*   1 option on left it is null  and  2 options for right trees.
         Those 2 right tree options can be formed with the root(1) in double for loop if only there is some
         value in left tree. So to iterate through left tree there should be atleast null and null is then paired with right tree options
         NOTE: If list is empty then the iteration does not go through.
             1                 1
           /   \             /    \
        null     2     or  null    3
                  \               /
                   3             2
         */
        if(start > end){ //if there are no options then return null tree in the list.
            trees.add(null); //so this null tree will be paired with all options on the other side of the root.
            return trees;  //Eg: If null is returned as leftTree then it is paired with all options formed for right side of a root.
        }

        for(int i=start; i <=end; i++){  //i is option for root value
            List<TreeNode> leftTrees =  generateTrees(start,  i-1);
            List<TreeNode> rightTrees =  generateTrees(i+1,  end);
            for(TreeNode leftTree:  leftTrees){   //for each left tree and right tree combination, create full tree with root node.
                for(TreeNode rightTree:  rightTrees){
//                    TreeNode root = new TreeNode(i);
//                    root.left = leftTree;
//                    root.right = rightTree;
                    TreeNode root = new TreeNode(i,leftTree,rightTree); //form tree with one node as root and already found left and right trees
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
