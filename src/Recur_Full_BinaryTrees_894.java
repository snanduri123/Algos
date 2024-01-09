/*
Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.



Example 1:


Input: n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
Example 2:

Input: n = 3
Output: [[0,0,0]]


Constraints:

1 <= n <= 20
 */


import java.util.ArrayList;
import java.util.List;

public class Recur_Full_BinaryTrees_894 {
    public List<TreeNode> allPossibleFBT1(int n) {

        if (n % 2 == 0) //if even, then can't form full BT as per question (need 2 children for every node).
            return new ArrayList<>();

        if (n == 1) {  //if there is 1 node then return it as one tree in the list.
            TreeNode root = new TreeNode(0);
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            return list;
        }

        List<TreeNode> treesWithCurrNodeAsRoot = new ArrayList<>(); //all possible trees than can be formed for a root with different number of nodes on left and right side..
        for (int left = 1; left <= n - 2; left = left + 2) { //no.of nodes distribution options for left and right side
            List<TreeNode> leftTrees = allPossibleFBT(left);
            List<TreeNode> rightTrees = allPossibleFBT(n - left - 1);  //-1 bcoz, 1 node is reserved for root.
            for (TreeNode leftTree : leftTrees) {  //for each left tree and right tree combination, create full tree with root node.
                for (TreeNode rightTree : rightTrees) {
//                    TreeNode root = new TreeNode(0);
//                    root.left = leftTree;
//                    root.right = rightTree;
                    TreeNode root = new TreeNode(0,leftTree,rightTree); //form tree with one node as root and already found left and right trees
                    treesWithCurrNodeAsRoot.add(root);
                }
            }
        }
        return treesWithCurrNodeAsRoot;
    }

    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0)
            return new ArrayList<>();
        return allPossibleFBT(1,n);
    }
    public List<TreeNode> allPossibleFBT(int start, int end) {
        List<TreeNode> answer = new ArrayList<>();
        if((end- start + 1) %2 == 0)  //if even nodes then return empty list
            return new ArrayList<>();
        if(start == end){  //if 1 node then return that.
            TreeNode n = new TreeNode(0);
            answer.add(n);
            return answer;
        }
        for(int i = start; i <= end; i++){  //both i<end and i<=end works
            List<TreeNode> leftTrees =  allPossibleFBT(start,  i-1);
            List<TreeNode> rightTrees =  allPossibleFBT(i+1,  end);
            for(TreeNode leftTree:  leftTrees){
                for(TreeNode rightTree:  rightTrees){
                    TreeNode root = new TreeNode(0);
                    root.left = leftTree;
                    root.right = rightTree;
                    answer.add(root);
                }
            }
        }
        return answer;
    }
}
