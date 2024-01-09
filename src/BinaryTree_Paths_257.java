/*
Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.



Example 1:

                    1
                  /   \
                 2     3
                 \
                  5

Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]

 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTree_Paths_257 {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<>();

        dfs(root, new StringBuilder(), paths);
        //dfs_string(root, "", paths);  // using string, not better than String builder.
        return paths;
    }


    public void dfs(TreeNode root, StringBuilder currPath, List<String> allPaths) {

        if (root == null)
            return;

        if (currPath.length() == 0) {   // if path is not created before then just add the root val
            currPath.append(root.val);
        } else {                        // if path is already created before then add "->" and the root val too continue the path.
            currPath.append("->").append(root.val);
        }

        if (root.left == null && root.right == null) {  //if leaf node then add the path to answer.
            allPaths.add(currPath.toString());
            return; //even without this return statement, the code works.
        }

        dfs(root.left, new StringBuilder(currPath), allPaths);   // If new StringBuilder() is not used because the currPath gets modified in the recursion because stringbuilder is mutable.
        dfs(root.right, new StringBuilder(currPath), allPaths);  //    so to retain the path from top to current node, we use new String builder.

    }


    public void dfs_string(TreeNode root, String currPath, List<String> allPaths) {

        if (root == null)
            return;

        if (currPath.isEmpty()) {
            // path.concat(String.valueOf(root.val)); //not working
            currPath = currPath + root.val;
        } else {
            currPath = currPath + "->" + root.val;
        }

        if (root.left == null && root.right == null)
            allPaths.add(currPath);

        dfs_string(root.left, currPath, allPaths);
        dfs_string(root.right, currPath, allPaths);

    }

    public static void main(String[] args) {
        BinaryTree_Paths_257 b = new BinaryTree_Paths_257();

        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2, null, null);
        n1.right = new TreeNode(3, null, null);
        n1.left.right = new TreeNode(5, null, null);
        System.out.println(b.binaryTreePaths(n1)); // [1->2->5, 1->3]


        TreeNode n2 = new TreeNode(1);
        System.out.println(b.binaryTreePaths(n2)); //[1]
    }
}
