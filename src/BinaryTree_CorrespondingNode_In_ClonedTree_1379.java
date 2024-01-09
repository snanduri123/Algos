/*
Given two binary trees original and cloned and given a reference to a node target in the original tree.

The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.



Example 1:


Input: tree = [7,4,3,null,null,6,19], target = 3
Output: 3
Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
Example 2:


Input: tree = [7], target =  7
Output: 7
Example 3:


Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
Output: 4


Constraints:

The number of nodes in the tree is in the range [1, 104].
The values of the nodes of the tree are unique.
target node is a node from the original tree and is not null.

 */

public class BinaryTree_CorrespondingNode_In_ClonedTree_1379 {


    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target)
            return cloned;
        TreeNode res = getTargetCopy(original.left, cloned.left, target);
        if (res != null)
            return res;
        return getTargetCopy(original.right, cloned.right, target);
    }



    //
    //Time: O(m + n)
    //Space: O(m + n)
    //Use this technique if we need to return node from tree (may not be cloned) which may have some nodes different.
    // because cloned means everything is similar.
    public final TreeNode getTargetCopy2(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if ((original == null && cloned == null) || (original != null && cloned == null) ||
                (original == null && cloned != null))
            return null;

        return getTargetInClone(cloned, target);

    }

    public TreeNode getTargetInClone(TreeNode cloned, TreeNode target) {
        TreeNode clonedTargetNode = null;

        if (cloned == null)
            return null;

        if (cloned.val == target.val) {
            clonedTargetNode = isSame(target, cloned) ? cloned : null;
        }

        if (clonedTargetNode == null) {
            clonedTargetNode = getTargetInClone(cloned.left, target);

            if (clonedTargetNode == null)
                clonedTargetNode = getTargetInClone(cloned.right, target);
        }


        return clonedTargetNode;

    }

    public boolean isSame(TreeNode original, TreeNode cloned) {

        boolean left = false;
        boolean right = false;

        if (original == null && cloned == null)
            return true;

        if (original == null || cloned == null)
            return false;

        if (original.val == cloned.val) {
            left = isSame(original.left, cloned.left);
            right = isSame(original.right, cloned.right);
        }

        return left && right;
    }

    public static void main(String[] args) {

        BinaryTree_CorrespondingNode_In_ClonedTree_1379 b = new BinaryTree_CorrespondingNode_In_ClonedTree_1379();
       /*1.
                  original                   cloned
                       7                        7
                     /   \                    /    \
                    4     3*                 4      3*
                         /  \                     /   \
                        6    19                  6     19

                3 is target. So return node with 3 in cloned Tree.
         */



        TreeNode n1 = new TreeNode(7, null, null);
        n1.left = new TreeNode(4, null, null);
        n1.right = new TreeNode(3, null, null);
        n1.right.left = new TreeNode(6, null, null);
        n1.right.right = new TreeNode(19, null, null);


        TreeNode n2 = new TreeNode(7, null, null);
        n2.left = new TreeNode(4, null, null);
        n2.right = new TreeNode(3, null, null);
        n2.right.left = new TreeNode(6, null, null);
        n2.right.right = new TreeNode(19, null, null);

        TreeNode target = n1.right;

        System.out.println(b.getTargetCopy(n1, n2, target).val); // 3


        /*2.
                  original                   cloned
                       7                       7


                7 is target. So return  node with 7 in cloned Tree.
         */
        TreeNode n3 = new TreeNode(7, null, null);

        TreeNode n4 = new TreeNode(7, null, null);

        TreeNode target2 = n3;

        System.out.println(b.getTargetCopy2(n3, n4, target2).val); // 7


         /*3.
                  original                   cloned
                       8                         8
                         \                        \
                          6                        8
                           \                        \
                            5                        5
                             \                        \
                              4*                       4*
                               \                        \
                                3                        3
                                 \                        \
                                  2                        2


                4 is target. So return node with 4 in cloned Tree.
         */

        TreeNode n33 = new TreeNode(8, null, null);
        n33.right = new TreeNode(6, null, null);
        n33.right.right = new TreeNode(5, null, null);
        n33.right.right.right = new TreeNode(4, null, null);
        n33.right.right.right.right = new TreeNode(3, null, null);
        n33.right.right.right.right.right = new TreeNode(2, null, null);
        n33.right.right.right.right.right.right = new TreeNode(1, null, null);

        TreeNode n44 = new TreeNode(8, null, null);
        n44.right = new TreeNode(6, null, null);
        n44.right.right = new TreeNode(5, null, null);
        n44.right.right.right = new TreeNode(4, null, null);
        n44.right.right.right.right = new TreeNode(3, null, null);
        n44.right.right.right.right.right = new TreeNode(2, null, null);
        n44.right.right.right.right.right.right = new TreeNode(1, null, null);

        TreeNode target33 = n33.right.right.right;

        System.out.println(b.getTargetCopy(n33, n44, target33).val); // 4


            /*3.
                  original                   cloned
                       8                         8
                         \                        \
                          6                        8
                           \                        \
                            5                        5
                             \                        \
                              4                        4
                               \                        \
                                4*                       4*
                                 \                        \
                                  3                        3
                                   \                        \
                                    2                        2


                4 is target. So return node with 4 in cloned Tree.
         */

        TreeNode n55 = new TreeNode(8, null, null);
        n55.right = new TreeNode(6, null, null);
        n55.right.right = new TreeNode(5, null, null);
        n55.right.right.right = new TreeNode(4, null, null);
        n55.right.right.right.right = new TreeNode(4, null, null);
        n55.right.right.right.right.right = new TreeNode(3, null, null);
        n55.right.right.right.right.right.right = new TreeNode(2, null, null);
        n55.right.right.right.right.right.right.right = new TreeNode(1, null, null);


        TreeNode n66 = new TreeNode(8, null, null);
        n66.right = new TreeNode(6, null, null);
        n66.right.right = new TreeNode(5, null, null);
        n66.right.right.right = new TreeNode(4, null, null);
        n66.right.right.right.right = new TreeNode(4, null, null);
        n66.right.right.right.right.right = new TreeNode(3, null, null);
        n66.right.right.right.right.right.right = new TreeNode(2, null, null);
        n66.right.right.right.right.right.right.right = new TreeNode(1, null, null);

        TreeNode target55 = n55.right.right.right.right;

        System.out.println(b.getTargetCopy(n55, n66, target55).val); // 4




        /*3.
                  original                   subTree
                       7
                     /   \
                    4     3*                        3
                         /  \                     /   \
                        6    19                  6     19

                3 is target. So return node with 3 in cloned Tree.
         */



        TreeNode n5 = new TreeNode(7, null, null);
        n5.left = new TreeNode(4, null, null);
        n5.right = new TreeNode(3, null, null);
        n5.right.left = new TreeNode(6, null, null);
        n5.right.right = new TreeNode(19, null, null);


        TreeNode n6 = new TreeNode(3, null, null);
        n6.left = new TreeNode(6, null, null);
        n6.right = new TreeNode(19, null, null);


        TreeNode target3 = n5.right;

        System.out.println(b.getTargetCopy2(n5, n6, target3).val); // 3
    }
}
