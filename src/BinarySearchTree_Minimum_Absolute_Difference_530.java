public class BinarySearchTree_Minimum_Absolute_Difference_530 {


    int minDiff = Integer.MAX_VALUE;
    TreeNode prevNode = null;

    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }

    public void inorderTraversal(TreeNode root) {

        if (root == null)
            return;


        inorderTraversal(root.left);

        if (prevNode != null) {
            minDiff = Math.min((root.val - prevNode.val), minDiff);
        }

        prevNode = root;
        inorderTraversal(root.right);


    }

    public static void main(String args[]) {
        BinarySearchTree_Minimum_Absolute_Difference_530 m = new BinarySearchTree_Minimum_Absolute_Difference_530();
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);

        System.out.println(m.getMinimumDifference(root1)); //1
    }
}
