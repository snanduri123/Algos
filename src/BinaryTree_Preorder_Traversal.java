import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*Given the root of a binary tree, return the preorder traversal of its nodes' values.



Example 1:


Input: root = [1,null,2,3]
Output: [1,2,3]


Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Eg:

                  10
           /            \
          5              15
       /     \          /
      3       8        12
    /   \      \
   2     4      9

   Eg: O/P 10,5,3,2,4,8,9,15,12

print root, left and right

 */
public class BinaryTree_Preorder_Traversal {

    List<Integer> l = new ArrayList<>();


    //Just printing method.
    public static void preorderTraversalPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderTraversalPrint(root.left);
        preorderTraversalPrint(root.right);
    }

    //using recursion.
    //Time : O(n)
    //Space: O(n) The space is taken up by the recursive call stack. Ideally, we are not using any extra space for variables.
    //        But the recursion internally uses a call stack that takes up space equivalent to the depth of the tree. The max depth of the tree could be
    //        O(n) in the worst-case scenario when the tree is skewed.
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        l.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return l;
    }

    //using stack
    //Time : O(n)
    //Space: O(n)
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> out = new ArrayList<Integer>();
        if (root == null) return out;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            out.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return out;
    }

    public static void main(String args[]) {

        BinaryTree_Preorder_Traversal B = new BinaryTree_Preorder_Traversal();

        /*

                              10
                       /            \
                      5              15
                   /     \          /
                  3       8        12
                /   \      \
               2     4      9

               Eg: O/P 10,5,3,2,4,8,9,15,12

         */
        TreeNode root = new TreeNode(10, null, null);
        root.left = new TreeNode(5, null, null);
        root.right = new TreeNode(15, null, null);
        root.left.left = new TreeNode(3, null, null);
        root.left.right = new TreeNode(8, null, null);
        root.right.left = new TreeNode(12, null, null);
        root.left.left.left = new TreeNode(2, null, null);
        root.left.left.right = new TreeNode(4, null, null);
        root.left.right.right = new TreeNode(9, null, null);
        //preorderTraversalPrint(root);  //[10, 5, 3, 2, 4, 8, 9, 15, 12]
        System.out.println(B.preorderTraversal(root)); //[10, 5, 3, 2, 4, 8, 9, 15, 12]

        B.l.clear(); //cleanup result list for the next test case.
        System.out.println("");


        TreeNode root1 = new TreeNode(10, null, null);
        root1.left = new TreeNode(5, null, null);
        root1.right = new TreeNode(15, null, null);
        root1.left.left = new TreeNode(3, null, null);
        root1.left.right = new TreeNode(8, null, null);
        root1.right.left = new TreeNode(12, null, null);
        root1.right.right = new TreeNode(17, null, null);
        root1.left.left.left = new TreeNode(2, null, null);
        root1.left.left.right = new TreeNode(4, null, null);
        root1.left.right.left = new TreeNode(7, null, null);
        root1.left.right.right = new TreeNode(9, null, null);
       // preorderTraversalPrint(root1);
        System.out.println(B.preorderTraversal(root1));

    }

}
