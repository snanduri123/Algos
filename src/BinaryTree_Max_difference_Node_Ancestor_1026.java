/*
Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.



Example 1:

                      8
               /           \
              3              10
           /    \              \
          1      6               14
               /    \           /
              4      7         13



Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.


Example 2:
                1
                 \
                  2
                   \
                    0
                   /
                  3

Input: root = [1,null,2,null,0,3]
Output: 3    Explanation: |3 - 0| = 3

 */

public class BinaryTree_Max_difference_Node_Ancestor_1026 {

    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {

        if(root == null)
            return 0;
        dfs( root, root.val, root.val);
        return maxDiff;

    }


    public void dfs(TreeNode root, int min, int max){

        if (root != null) {
            //compute local maxdiff
            maxDiff = Math.max(maxDiff, Math.abs(root.val - min));
            maxDiff = Math.max(maxDiff, Math.abs(root.val - max));

            // values to send to children
            max = Math.max(max, root.val);
            min = Math.min(min, root.val);
            dfs(root.left, min, max);
            dfs(root.right, min, max);
        }
    }

    public Integer[] dfs2(TreeNode root){
        if(root == null)
            return null;

        Integer[] leftMinMax = dfs2(root.left);
        Integer[] rightMinMax = dfs2(root.right);

        // return to parent
        if (leftMinMax == null && rightMinMax == null) {
            // diff is 0
            return new Integer[] {root.val, root.val};
        } else if (leftMinMax == null) {
            maxDiff = Math.max(maxDiff, Math.max(Math.abs(root.val - rightMinMax[0]), Math.abs(root.val - rightMinMax[1])));
            return new Integer[] {Math.min(root.val, rightMinMax[0]), Math.max(root.val, rightMinMax[1])};
        } else if (rightMinMax == null) {
            maxDiff = Math.max(maxDiff, Math.max(Math.abs(root.val - leftMinMax[0]), Math.abs(root.val - leftMinMax[1])));
            return new Integer[] {Math.min(root.val, leftMinMax[0]), Math.max(root.val, leftMinMax[1])};
        } else {

            int minChild = Math.min(leftMinMax[0], rightMinMax[0]);
            int maxChild = Math.max(leftMinMax[1], rightMinMax[1]);

            maxDiff = Math.max(maxDiff, Math.abs(root.val - minChild));
            maxDiff = Math.max(maxDiff, Math.abs(root.val - maxChild));

            int min = Math.min(Math.min(leftMinMax[0], rightMinMax[0]), root.val);
            int max = Math.max(Math.max(leftMinMax[1], rightMinMax[1]), root.val);
            return new Integer[] {min, max};
        }
    }


    public static void main(String[] args){
        BinaryTree_Max_difference_Node_Ancestor_1026 b = new BinaryTree_Max_difference_Node_Ancestor_1026();

        /*            8
               /           \
              3              10
           /    \              \
          1      6               14
               /    \           /
              4      7         13

         */
        TreeNode n1 = new TreeNode(8, null, null);
        n1.left = new TreeNode(3, null, null);
        n1.right = new TreeNode(10, null, null);
        n1.left.left = new TreeNode(1, null, null);
        n1.left.right = new TreeNode(6, null, null);
        n1.left.right.left = new TreeNode(4, null, null);
        n1.left.right.right = new TreeNode(7, null, null);
        n1.right.right = new TreeNode(14, null, null);
        n1.right.right.left = new TreeNode(13, null, null);

        System.out.println(b.maxAncestorDiff(n1));  // 8 -1 = 7

    }
}
