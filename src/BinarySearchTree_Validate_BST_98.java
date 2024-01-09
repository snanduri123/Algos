

public class BinarySearchTree_Validate_BST_98 {

    //Time: O(N) worst case - height of the tree
    //Space:O(N) worst case - height of the tree
    public boolean isValidBST(TreeNode root){
        return  isValidBST( root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if(root == null)
            return true;

        return root.val > minValue && root.val < maxValue &&
                isValidBST(root.left, minValue, root.val) &&
                isValidBST(root.right, root.val, maxValue);
    }

    public static void main(String[] args) {

        BinarySearchTree_Validate_BST_98 b = new BinarySearchTree_Validate_BST_98();

        Integer arr1[] = {2,2,2};
        TreeNode root1 = new TreeNode();
        root1 = TreeNode.insertLevelOrder(arr1, root1, 0);

        System.out.println(b.isValidBST(root1)); //false

        TreeNode root2 = new TreeNode(2147483647);
        System.out.println(b.isValidBST(root2)); //true


        Integer arr3[] = {1,2,3};
        TreeNode root3 = new TreeNode();
        root3 = TreeNode.insertLevelOrder(arr3, root3, 0);
        System.out.println(b.isValidBST(root3)); //true

    }
}
