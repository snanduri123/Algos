/*
Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.



Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1


Constraints:

The number of nodes in the tree is in the range [2, 100].
0 <= Node.val <= 105


Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */


public class BinarySearchTree_Minimum_Distance_Between_Nodes_783 {
    int minDistance = Integer.MAX_VALUE;
    TreeNode prevNode;
    public int minDiffInBST(TreeNode root) {
        inorderTraversal(root);
        return minDistance;
    }

    //Time: O(n)
    //Space: O(h) //stack occupies the depth/height of the nodes. In worst case h=n Eg: Tree has only long left side nodes or only right side nodes.
    // About prevNode:  the leftmost node will be the first prevNode.
    // 1. Do inorder traversal so that minimum distance is calculated between root.left and root ; root.right and root
    // 2.But if the parent root has rightmost nodes in the left half of the tree and leftmost nodes in the right half of the tree
    //   then we also need to find the min distance between parent node and the rightmost node in left tree and
    //   the min distance between parent node and the leftmost node. See the root4 and root5 test cases.
    // 3. The distance between left and right child nodes of a root in binary SEARCH tree need not be calculated because obviously
    //      (root - left) < (left - right)  or  (right - root) < (left - right)
    // means in binary search tree left side nodes have smaller value than root and root's value is smaller than right side nodes.
    public void inorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);

        if(prevNode !=null){
            minDistance = Math.min(minDistance, root.val - prevNode.val);
        }
        prevNode = root;
        inorderTraversal(root.right);
    }


    public static void main(String args[]) {

         /*
                     2
                  /    \
                 1      3

               2 - 1 = 1 or 3 - 2 = 1
         */
        BinarySearchTree_Minimum_Distance_Between_Nodes_783 m = new BinarySearchTree_Minimum_Distance_Between_Nodes_783();
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        System.out.println(m.minDiffInBST(root1)); //1


           /*
                     4
                  /    \
                 2      6
               /   \
              1     3

               4 - 3 = 1
         */
        //[4,2,6,1,3]
        BinarySearchTree_Minimum_Distance_Between_Nodes_783 m2 = new BinarySearchTree_Minimum_Distance_Between_Nodes_783();
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);

        System.out.println(m2.minDiffInBST(root2)); //1




        /*
                1
              /   \
              0    48
                  /   \
                 12   49
         */
        //[1,0,48,null,null,12,49]
        BinarySearchTree_Minimum_Distance_Between_Nodes_783 m3 = new BinarySearchTree_Minimum_Distance_Between_Nodes_783();
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(0);
        root3.right = new TreeNode(48);
        root3.right.left = new TreeNode(12);
        root3.right.right = new TreeNode(49);

        System.out.println(m3.minDiffInBST(root3)); //1


        //[90,69,null,49,89,null,52]

        /*
                   90
                  /
                 69
               /   \
              49   89
               \
               52

               90 - 89 = 1
         */
        BinarySearchTree_Minimum_Distance_Between_Nodes_783 m4 = new BinarySearchTree_Minimum_Distance_Between_Nodes_783();
        TreeNode root4 = new TreeNode(90);
        root4.left = new TreeNode(69);
        root4.left.left = new TreeNode(49);
        root4.left.right = new TreeNode(89);
        root4.left.left.right = new TreeNode(52);

        System.out.println(m4.minDiffInBST(root4)); //1


         /*
                5
              /   \
             1     48
                  /   \
                 7    54

            7 -5 = 2
         */

        BinarySearchTree_Minimum_Distance_Between_Nodes_783 m5 = new BinarySearchTree_Minimum_Distance_Between_Nodes_783();
        TreeNode root5 = new TreeNode(5);
        root5.left = new TreeNode(1);
        root5.right = new TreeNode(48);
        root5.right.left = new TreeNode(7);
        root5.right.right = new TreeNode(54);

        System.out.println(m5.minDiffInBST(root5)); //2
    }
}
