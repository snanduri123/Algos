/*
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

Example :

Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5   - 5 is unval tree because it has same value child node(s)
           / \   \
          5   5   5  - three 5 leaf nodes themselves are unvial trees

Output: 4

TimeComplexity = O(n)
SpaceComplexity - O(1)
 */


public class BinaryTree_CountOfUnivalueSubtrees_250 {

    //Time: O(n)
    //Space: O(n)
    public int countUnivalSubtrees(TreeNode root) {
        helperObject obj =   countUnivalSubtreeshelper( root);
        return obj.countOfUnivalSubtrees;
    }


    public helperObject countUnivalSubtreeshelper(TreeNode root) {

        if (root == null) {
            return new helperObject(true, 0);
        }

        System.out.println("root " + root.val);
        helperObject left = null;
        helperObject right = null;

        left = countUnivalSubtreeshelper(root.left);
        right = countUnivalSubtreeshelper(root.right);

        if (left.isUnival && right.isUnival) {

            if ((root.left != null && root.val != root.left.val) || (root.right != null && root.val != root.right.val)) {
                return new helperObject(false, left.countOfUnivalSubtrees + right.countOfUnivalSubtrees);
            } else {
                return new helperObject(true, left.countOfUnivalSubtrees + right.countOfUnivalSubtrees + 1);
            }

        }
        return new helperObject(false, left.countOfUnivalSubtrees + right.countOfUnivalSubtrees);
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(5);
        BinaryTree_CountOfUnivalueSubtrees_250 c = new BinaryTree_CountOfUnivalueSubtrees_250();
        System.out.println(c.countUnivalSubtrees(node));

    }
}

class helperObject {
    boolean isUnival;
    int countOfUnivalSubtrees;

    helperObject(boolean isUnival, int count) {
        this.isUnival = isUnival;
        this.countOfUnivalSubtrees = count;
    }
}
