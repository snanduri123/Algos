/*
Consider all the leaves of a binary tree, from left to right order,
the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.



Example 1:


Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
Example 2:


Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false


Constraints:

The number of nodes in each tree will be in the range [1, 200].
Both of the given trees will have values in the range [0, 200].

 */


import java.util.ArrayList;
import java.util.List;

public class BinaryTree_Leaf_Similar_Trees_872 {


    //Time: O(T1 + T2)  T1 and T2: depth of the tree1 and tree2
    //Space: O(T1 + T2)  all the leaf nodes of tree1 and tree2.
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        List<Integer> leafnodes1 = new ArrayList<>();
        findLeafNodes(root1, leafnodes1);

        List<Integer> leafnodes2 = new ArrayList<>();
        findLeafNodes(root2, leafnodes2);

        return leafnodes1.equals(leafnodes2);


    }

    public void findLeafNodes(TreeNode root, List<Integer> leafNodes) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            leafNodes.add(root.val);
        } else {
            findLeafNodes(root.left, leafNodes);
            findLeafNodes(root.right, leafNodes);
        }
    }

    public static void main(String args[]) {
        BinaryTree_Leaf_Similar_Trees_872 s = new BinaryTree_Leaf_Similar_Trees_872();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println(s.leafSimilar(root1, root2));
    }
}