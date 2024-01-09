/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.


Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100


Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 */

public class BinaryTree_Flatten_To_LinkedList_114 {

    //Time : O(n)
    //Space: O(n)
    public void flatten(TreeNode root) {
        flattenInPreOrder( root);
    }
    public TreeNode flattenInPreOrder(TreeNode root){
        if(root == null)  // when right node is null, in recursion it comes here and just returns null. LeftTree wont come here because we have check below (if not null only then do recursion)
            return null;
        if(root.left == null && root.right == null) //if leaf node then no need to flatten and just return itself.
            return root;
        TreeNode right = root.right;
        TreeNode leftLeafNode = null; //rightmost node of left tree
        TreeNode rightLeafNode = null;
        if(root.left!=null){
            root.right = root.left; //left tree is moved to right
            root.left = null;
            leftLeafNode = flattenInPreOrder(root.right); //flatten the left tree and get the last node which will be the so far rightmost node because left tree is already moved to right
            leftLeafNode.right = right; // attach the right tree to the recently found last node from flattened left tree.
        }
        rightLeafNode = flattenInPreOrder(right); //flatten right tree. Gives, rightmost node after flattening.
        //return the "rightmost" node. If there was no rightLeafNode (bcoz no right tree0 then the leftLeafNode
        return rightLeafNode == null ?  leftLeafNode : rightLeafNode;
    }

    public static void main(String args[]){

        /*
        1,2,5,3,4,null,6
                       1
                    /     \
                   2       5
                  / \       \
                 3   4       6

                 o/p : 1,null,2,null,3,null,4,null,5,null,6
         */
        BinaryTree_Flatten_To_LinkedList_114 b = new BinaryTree_Flatten_To_LinkedList_114();
        TreeNode root = new TreeNode (1, null, null);
        root.left = new TreeNode (2, null, null);
        root.right = new TreeNode (5, null, null);
        root.left.left = new TreeNode (3, null, null);
        root.left.right = new TreeNode (4, null, null);
        root.right.right = new TreeNode (6, null, null);
        b.flatten(root);
        print(root);

        System.out.println("");
         /*
          1,2,null,3,4,5
                       1
                    /
                   2
                  / \
                 3   4
                /
               5

               o/p : 1,null,2,null,3,null,5,null,4
         */
        TreeNode root2 = new TreeNode (1, null, null);
        root2.left = new TreeNode (2, null, null);
        root2.left.left = new TreeNode (3, null, null);
        root2.left.right = new TreeNode (4, null, null);
        root2.left.left.left = new TreeNode (5, null, null);
        b.flatten(root2);
        print( root2);
    }

    public static void print(TreeNode root){
        if(root == null){
            System.out.print("null, ");
            return;
        }
        System.out.print(root.val + ", ");
        print(root.left);
        print(root.right);
    }
}
