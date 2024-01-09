/*
Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

        1
         \
          2
         /
        2
Input: root = [1,null,2,2]
Output: [2]

Example 2:

Input: root = [0]
Output: [0]

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree_Find_Mode_501 {

    int freq;
    int maxFreq;
    TreeNode prev = null;

    //Time: O(n)
    //Space: O(1) // stack memory is O(n) for recursion but heap memory is taken as O(1) because the  list/array used is anyway to return the answer.
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        int[] result;
        prev = root; freq = 0;  maxFreq = 0; // global variables have to be initialized here only otherwise for running many test cases the result will be corrupted.
        inorderTraverse(root, modes);

        result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    public void inorderTraverse(TreeNode root, List<Integer> modes) {

        if (root == null)
            return;

        inorderTraverse(root.left, modes);

        if (root.val == prev.val)
            freq = freq + 1;
        else
            freq = 1;

        if (freq == maxFreq)
            modes.add(root.val);
        else if (freq > maxFreq) {
            modes.clear();
            modes.add(root.val);
            maxFreq = freq;
        }

        prev= root;

        inorderTraverse(root.right, modes);
    }


    public static void main(String[] args) {

        int[] result;
        BinarySearchTree_Find_Mode_501 b = new BinarySearchTree_Find_Mode_501();

        TreeNode n1 = new TreeNode(1, null, null);
        n1.right = new TreeNode(2, null, null);
        result = b.findMode(n1);
        System.out.println(Arrays.toString(result)); //1,2


        TreeNode n2 = new TreeNode(1, null, null);
        n2.right = new TreeNode(2, null, null);
        n2.right.left = new TreeNode(2, null, null);
        result = b.findMode(n2);
        System.out.println(Arrays.toString(result)); //2
    }

}
