public class BinaryTree_Sum_of_left_leaves {

    public int sumOfLeftLeaves(TreeNode root) {

        if((root ==null) || (root.left ==null && root.right==null))
            return 0;

        return findLeftLeafSum(root, false);
    }

    public int findLeftLeafSum(TreeNode root, boolean isLeft){
        if(root ==null)
            return 0;

        if(root.left ==null && root.right==null && isLeft)
            return root.val;

        int leftLeftLeafSum = findLeftLeafSum(root.left, true);

        int rightLeftLeafSum = findLeftLeafSum(root.right, false);

        return leftLeftLeafSum + rightLeftLeafSum;

    }

    public static void main(String args[]) {
        BinaryTree_Sum_of_left_leaves s = new BinaryTree_Sum_of_left_leaves();
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println(s.sumOfLeftLeaves(root1)); //9 + 15 = 24

        BinaryTree_Sum_of_left_leaves s2 = new BinaryTree_Sum_of_left_leaves();
        TreeNode root2 = new TreeNode(3);
        System.out.println(s2.sumOfLeftLeaves(root2)); //0

        BinaryTree_Sum_of_left_leaves s3 = new BinaryTree_Sum_of_left_leaves();
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        System.out.println(s3.sumOfLeftLeaves(root3)); //2

        BinaryTree_Sum_of_left_leaves s4 = new BinaryTree_Sum_of_left_leaves();
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        System.out.println(s4.sumOfLeftLeaves(root4)); //4

    }
}
