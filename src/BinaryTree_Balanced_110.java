public class BinaryTree_Balanced_110 {


    // Bottom to top approach so that each node is visited only once.
    // Time : O(n)
    //Space: O(n) for recursion stack
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        int depth = isBalancedDepth(root);

        if(depth == -1)
            return false;
        return true;
    }

    public int isBalancedDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = isBalancedDepth(root.left);
        int right = isBalancedDepth(root.right);

        if(left == -1 || right == -1)
            return -1;

        int depth =  Math.max(left,right) + 1;

        if(Math.abs(right-left) > 1)
            depth = -1;

        return depth;
    }

    // Top to Bottom approach - the child nodes are visited every time the height is calculated for each node from the top.
    //Time : O(nlogn)
    //Space: O(n)
    public boolean isBalanced1(TreeNode root) {
        if(root == null)
            return true;

        int left = findDepth(root.left);
        int right = findDepth(root.right);

        return (Math.abs(left-right) <=1) && isBalanced(root.left) && isBalanced(root.right);
    }
    public int findDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int leftDepth = 1 + findDepth(root.left);
        int rightDepth = 1 + findDepth(root.right);

        return Math.max(leftDepth,rightDepth);

    }

    public static void main(String[] args) {
//        /*
//                    1
//                 2     2
//              3           3
//            4               4
//
//           Top root (1) looks balanced but if we take root (=2) then on one side of it we have two nodes and
//            another side no nodes. So here child nodes are not balanced.
//         */

        BinaryTree_Balanced_110 b = new BinaryTree_Balanced_110();

        Integer arr[] = {1, 2, 2, 3, null, null, 3, 4, null, null, 4};
        TreeNode root = new TreeNode();
        root = TreeNode.insertLevelOrder(arr, root, 0);
        root.right.right.right = new TreeNode(4);
        System.out.println(b.isBalanced(root)); //false

        //---------------------------
        /*     1
                    2
                            3*/
        Integer arr2[] = {1, null, 2, null, 3};
        TreeNode root2 = new TreeNode();
        root2 = TreeNode.insertLevelOrder(arr2, root2, 0);
        root2.right.right = new TreeNode(3);
        System.out.println(b.isBalanced(root2)); //false


        //---------------------------
        /*           3
                  /     \
                 9        2
                       /     \
                      15      7
        */
        Integer arr3[] = {3, 9, 20, null, null, 15, 7};
        TreeNode root3 = new TreeNode();
        root3 = TreeNode.insertLevelOrder(arr3, root3, 0);
        System.out.println(b.isBalanced(root3)); //true

        //---------------------------
        /*           1
                  /     \
                 2       2
              /     \
             3       3
          /     \
          4     4
        */
        Integer arr4[] = {1,2,2,3,3,null,null,4,4};
        TreeNode root4 = new TreeNode();
        root4 = TreeNode.insertLevelOrder(arr4, root4, 0);
        System.out.println(b.isBalanced(root4)); //false
    }
}
