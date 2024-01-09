
/*
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a 3-ary tree:

              1
     3        2      4
   5   6

We should return its max depth, which is 3.



Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.

 */

import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

/* For recursion
Time complexity : we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.

Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only one child node,
the recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack would be O(N).
But in the best case (the tree is completely balanced), the height of the tree would be log(N).
Therefore, the space complexity in this case would be O(log(N)).
*/
public class Maximum_Depth_of_N_ary_Tree_559 {

    public int maxDepth(Node root) {
        if (root == null) {  // this is helpful in case a node has only one child then in recursion this method will be called for that one child and also null.
            return 0;
        }
        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }

        int maxDepth = Integer.MIN_VALUE;
        for (Node child : root.children) {
            int depth = maxDepth(child) + 1;
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        }


        return maxDepth;

    }
}
