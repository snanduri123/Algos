/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.



Example 1:
            3
         /     \
        1       4
         \
          2

Input: root = [3,1,4,null,2], k = 1
Output: 1



Example 2:
            5
         /     \
        3       6
     /    \
    2      4
   /
  1

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3


Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104


Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree_Kth_Smallest_Element_230 {
    int nodesSeen = 0;
    int ans = 0;

    //Time: O(n)
    //Space: O(1)
    public int kthSmallest(TreeNode root, int k) {
         nodesSeen = 0;
         ans = 0;
        kthSmall(root, k);
        return ans;
    }

    public void kthSmall(TreeNode root, int k) {
        if (root == null)
            return;
        kthSmall(root.left, k);
        if (nodesSeen == k - 1) { //if previously seen is k-1 then current node is kth.
            ans = root.val;
        }
        nodesSeen++;
        kthSmall(root.right, k);
    }

    List<Integer> elements = new ArrayList<>();
    //Time: O(n)
    //Space: O(n)
    public int kthSmallest2(TreeNode root, int k) {
        inorder(root, k);
        return elements.get(k - 1);
    }

    public void inorder(TreeNode root, int k) {
        if (root == null)
            return;

        inorder(root.left, k);
        elements.add(root.val);
        inorder(root.right, k);
    }

    public static void main(String[] args) {
        BinarySearchTree_Kth_Smallest_Element_230 b = new BinarySearchTree_Kth_Smallest_Element_230();


        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        System.out.println(b.kthSmallest(root1, 1));//1
        System.out.println(b.kthSmallest(root1, 2));//2
        System.out.println(b.kthSmallest(root1, 3));//3
        System.out.println(b.kthSmallest(root1, 4));//4

        System.out.println("------------------");

//        TreeNode root2 = new TreeNode(5);
//        root2.left = new TreeNode(3);
//        root2.right = new TreeNode(6);
//        root2.left.left = new TreeNode(2);
//        root2.left.right = new TreeNode(4);
//        root2.left.left.left = new TreeNode(1);
//
//        System.out.println(b.kthSmallest(root1, 1));//1
//        System.out.println(b.kthSmallest(root1, 3));//3

    }
}
