// root.left, root.right, root

import java.util.ArrayList;
import java.util.List;

public class BinaryTree_PostOrder_Traversal {
    List<Integer> nodes = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return nodes;
    }

    public void postorder(TreeNode root) {

        if(root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        nodes.add(root.val);
    }
}
