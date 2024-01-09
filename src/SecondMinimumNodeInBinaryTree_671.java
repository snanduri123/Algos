/*
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

1.
Input: root = [2,2,5,null,null,5,7]
Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:

2.
Input: root = [2,2,2]
Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 */

import java.util.Arrays;

public class SecondMinimumNodeInBinaryTree_671 {


    int firstMin = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    boolean secMinFound = false;
    // Use preorder (check root, left, right) because - as per question root is min(left, right). That means
    // values will be increasing as you go down (left or right). so first if we check the root we know what is the
    // first minimum.
    // Time: O(n)
    //Space: O(n) //stack memory for recursion is the length of the tree.
    public int findSecondMinimumValue(TreeNode root){
        if (root == null)
                return 0;

        if(root.val <= firstMin){ // use if(root.val < firstMin) so that the value is not updated unnecessarily with same value.
            firstMin = root.val;
        }

        if(root.val > firstMin && root.val <= secondMin){ //** notice "<=" secondMin.
            secondMin = root.val;
            secMinFound = true;
        }

        findSecondMinimumValue(root.left);
        findSecondMinimumValue(root.right);

        return secMinFound ? secondMin : -1;
    }

    public int[] inorderTraversal(TreeNode root){
        if(root==null)
            return new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};

        int[] left = inorderTraversal(root.left);
        int[] right = inorderTraversal(root.right);

        int[] arr = new int[] {left[0], left[1], right[0], right[1], root.val};
        Arrays.sort(arr);

        return new int[] {arr[0], arr[1]};
    }

    public static void main(String[] args){

        //
        SecondMinimumNodeInBinaryTree_671 s = new SecondMinimumNodeInBinaryTree_671();
        TreeNode n1 = new TreeNode(2);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(5);
        n1.right.left = new TreeNode(5);
        n1.right.right = new TreeNode(7);
        System.out.println(s.findSecondMinimumValue(n1));  //5


        //no secondMin node because all are equal.
        SecondMinimumNodeInBinaryTree_671 s2 = new SecondMinimumNodeInBinaryTree_671();
        TreeNode n2 = new TreeNode(2);
        n2.left = new TreeNode(2);
        n2.right = new TreeNode(2);
        System.out.println(s2.findSecondMinimumValue(n2));  //-1


        //two types of nodes.
        SecondMinimumNodeInBinaryTree_671 s3 = new SecondMinimumNodeInBinaryTree_671();
        TreeNode n3 = new TreeNode(2);
        n3.left = new TreeNode(2);
        n3.right = new TreeNode(5);
        n3.right.left = new TreeNode(5);
        System.out.println(s3.findSecondMinimumValue(n3)); // 5


        //left side of the tree has secondMinNode.
        SecondMinimumNodeInBinaryTree_671 s4 = new SecondMinimumNodeInBinaryTree_671();
        TreeNode n4 = new TreeNode(5);
        n4.left = new TreeNode(8);
        n4.right = new TreeNode(5);
        System.out.println(s4.findSecondMinimumValue(n4)); // 5



        SecondMinimumNodeInBinaryTree_671 s5 = new SecondMinimumNodeInBinaryTree_671();
        TreeNode n5 = new TreeNode(2);
        n5.left = new TreeNode(2);
        n5.right = new TreeNode(2147483647);
        System.out.println(s5.findSecondMinimumValue(n5)); // 2147483647
    }
}
