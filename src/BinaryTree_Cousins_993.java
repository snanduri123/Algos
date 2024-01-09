/*Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.



Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:


Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false


Constraints:

The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.

 */


public class BinaryTree_Cousins_993 {
    int depthX = 0;
    TreeNode parentX = null;
    int depthY = 0;
    TreeNode parentY = null;

    //DFS
    //Time: O(N)
    //Space: O(N)
    public boolean isCousins(TreeNode root, int x, int y) {

        findDepth( root,  x,  y, 0, null);
        return (depthX==depthY)  && (parentX != parentY) ? true : false;

    }

    public void findDepth(TreeNode root, int x, int y, int depthFromRoot, TreeNode parent){
        if(root==null  )
            return;

        if(root.val == x ) {
            depthX = depthFromRoot;
            parentX = parent;
        }
        if(root.val == y) {
            depthY = depthFromRoot;
            parentY = parent;
        }

        if(parentX != null && parentY != null) //small optimization. Once both nodes are found then do not do recursion for remaining un searched nodes.
            return;

        findDepth(root.left, x, y, depthFromRoot+1, root);

        findDepth(root.right, x, y, depthFromRoot+1, root);
    }

    public static void main(String[] args) {
        BinaryTree_Cousins_993 b = new BinaryTree_Cousins_993();
//
//        /*
//                  1
//                /   \
//               2     3
//                \
//                 4
//         */
//
//        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
//        node.right = new TreeNode(3);
//        node.left.right = new TreeNode(4);
//        System.out.println("Depth of binary tree is : " +  b.isCousins(node,4,3)); // false
//
//           /*
//                  1
//                /   \
//               2     3
//                \     \
//                4      5
//         */
//
//        TreeNode node2 = new TreeNode(1);
//        node2.left = new TreeNode(2);
//        node2.right = new TreeNode(3);
//        node2.left.right = new TreeNode(4);
//        node2.right.right = new TreeNode(5);
//
//        System.out.println("Depth of binary tree is : " +  b.isCousins(node2,4,5)); // true
//
//
//          /*
//                  1
//                /   \
//               2     3
//                \
//                4
//         */
//
//        TreeNode node3 = new TreeNode(1);
//        node3.left = new TreeNode(2);
//        node3.right = new TreeNode(3);
//        node2.left.right = new TreeNode(4);
//
//        System.out.println("Depth of binary tree is : " +  b.isCousins(node3,2,3)); // false (parents are supposed to be different)
//
//
          /*
                  1
                /   \
               2     3
                \     \
                4      5
                /      /
               6       7
         */

        TreeNode node4 = new TreeNode(1);
        node4.left = new TreeNode(2);
        node4.right = new TreeNode(3);
        node4.left.right = new TreeNode(4);
        node4.right.right = new TreeNode(5);
        node4.left.right.left = new TreeNode(6);
        node4.right.right.left = new TreeNode(7);

        System.out.println("Depth of binary tree is : " +  b.isCousins(node4,4,5)); // true

    }
}
