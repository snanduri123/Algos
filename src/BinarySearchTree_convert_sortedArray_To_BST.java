/*
tree.



Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
 */

public class BinarySearchTree_convert_sortedArray_To_BST {

    // Time : O(n)
    //Space: O(log n) --   The recursion stack requires O(log n) space because the tree is height-balanced. Note that    // the O(N) space used to store the output does not count as auxiliary space, so it is not included in the space //complexity.
    // PreOrder traversal --> root, left and right
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums == null || nums.length == 0)
            return null;

        return constructBST(nums,0,nums.length-1);

    }

    public TreeNode constructBST(int nums[], int start, int end){
        if(start > end)
            return null;

        int mid = (start + end)/2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructBST(nums, start, mid-1);
        root.right = constructBST(nums, mid+1, end);

        return root;
    }


    public static void main(String[] args){
        BinarySearchTree_convert_sortedArray_To_BST b = new BinarySearchTree_convert_sortedArray_To_BST();

        /*
                      0
                     /  \
                   -3    5
                   /      \
                 -10       9
         */
        int arr1[] = {-10,-3,0,5,9};
        System.out.println(b.sortedArrayToBST(arr1).val); //0

        int arr2[] = {-10,-3,-2,-1,0};
        System.out.println(b.sortedArrayToBST(arr2).val); //-2
    }
}
