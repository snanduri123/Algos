/*
Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target. If there are multiple answers, print the smallest.



Example 1:


Input: root = [4,2,5,1,3], target = 3.714286
Output: 4
Example 2:

Input: root = [1], target = 4.428571
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109
 */

public class BinarySearchTree_Closest_Value_270 {

    double minDiff = Double.MAX_VALUE;
    int closeVal;

    public int closestValue(TreeNode root, double target) {

        closeVal = root.val;
        traverse(root, target);
        return closeVal;
    }

    //Time: O(n). (best case O(logn) because based on target either you go left or right of the BST.)
    //Space: O(h) (height of the tree. Worst case h=n)
    public void traverse(TreeNode root, double target) {

        if(root == null)
            return;

        if(Math.abs(root.val-target) < minDiff) {
            minDiff =  Math.abs(root.val-target);
            closeVal = root.val;
        }
        // "="  is very important because if there are two numbers close then first close should be returned as this is a binary tree. See the example root3 below.
        else if(Math.abs(root.val-target) == minDiff){
            closeVal = Math.min(closeVal,root.val);
        }

        if(root.val > target){
            traverse(root.left, target);
        }
        else{
            traverse(root.right, target);
        }
    }

    public static void main(String args[]) {
        //close to root node.
        BinarySearchTree_Closest_Value_270 m = new BinarySearchTree_Closest_Value_270();
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        System.out.println(m.closestValue(root1, 3.714286)); //4

        // only one node, so chose that node.
        BinarySearchTree_Closest_Value_270 m2 = new BinarySearchTree_Closest_Value_270();
        TreeNode root2 = new TreeNode(1);
        System.out.println(m2.closestValue(root2, 3.714286)); //1

        //close to root and rightmost node in left tree, so chose the rightmost node in the left tree as it is smaller.
        BinarySearchTree_Closest_Value_270 m3 = new BinarySearchTree_Closest_Value_270();
        TreeNode root3 = new TreeNode(4);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(5);
        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(3);
        System.out.println(m3.closestValue(root3, 3.5)); // 3  (both 3 and 4 are close but 3 is first closest.

        //close to right node.
        BinarySearchTree_Closest_Value_270 m4 = new BinarySearchTree_Closest_Value_270();
        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(2);
        System.out.println(m4.closestValue(root4, 3.5)); //2

        //close to root node and right node, so chose root node.
        BinarySearchTree_Closest_Value_270 m5 = new BinarySearchTree_Closest_Value_270();
        TreeNode root5 = new TreeNode(4);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(5);
        root5.left.left = new TreeNode(1);
        root5.left.right = new TreeNode(3);
        System.out.println(m5.closestValue(root5, 4.5)); // 4  (both 4 and 5 are close but 3 is first closest.
    }
}
