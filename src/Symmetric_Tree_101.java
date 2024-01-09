/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

        For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

              1
          /       \
         2         2
        /  \      /  \
       3    4    4    3

    For example, this binary tree [1,2,2,3,4,4,3,5,6,7,8,8,7,6,5] is symmetric:
              1
          /       \
         2         2
        /  \      /  \
       3    4    4    3
      / \  / \  / \  / \
     5  6 7  8 8  7 6   5


        But the following [1,2,2,null,3,null,3] is not:
          1
         / \
        2   2
        \   \
        3    3
        Note:
        Bonus points if you could solve it both recursively and iteratively.
        */

public class Symmetric_Tree_101 {

    public static void main(String args[])
    {
        Symmetric_Tree_101 s = new Symmetric_Tree_101();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(s.isSymmetric(root));


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(3);
        System.out.println(s.isSymmetric(root2));
    }

    //iterative medthod uses queue. TODO:

    //using recursion.
    //Time : O(n)
    //Space: O(n) The space is taken up by the recursive call stack. Ideally, we are not using any extra space for variables.
    //        But the recursion internally uses a call stack that takes up space equivalent to the depth of the tree. The max depth of the tree could be
    //        O(n) in the worst-case scenario when the tree is skewed.
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
       return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left==null && right ==null)
            return true;

        if((left==null)||(right==null) || left.val!=right.val)
            return false;
        else{
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
