import java.util.ArrayList;
import java.util.List;

public class BinaryTree_Boundary_545 {

    /*
    Time complexity : O(n) we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.
    Space complexity : O(n)
    */
    List<Integer> answer;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {  //top to bottom approach
        answer = new ArrayList<>();
        if(root!=null){
            answer.add(root.val);
        }
        addLeftBoundaryNode( root.left,  true);
        addRightBoundaryNode( root.right,  true);
        return answer;
    }

    // preOrder traversal (root, left, right) but postOrder for right boundary
    public void addLeftBoundaryNode(TreeNode node, boolean isBoundaryNode){
        if(node == null)
            return;
        boolean isLeaf = (node.left == null && node.right == null) ? true : false;
        //if its on boundary or if it is a leaf node then add it to result
        if(isBoundaryNode || isLeaf){
            answer.add(node.val);
        }
        if(!isLeaf) {  //optional condition. Can comment it out.
            addLeftBoundaryNode( node.left,  isBoundaryNode); // left nodes are always on boundary
            addLeftBoundaryNode( node.right,  node.left==null && isBoundaryNode); //right node can become boundary if currNode is on boundary and there is no left node. Otherwise it is just a right node for now and if it is a leaf node then in recursion it is considered to be boundary node.
        }
    }

    //postOrder (left, right, root)
    public void addRightBoundaryNode(TreeNode node, boolean isBoundaryNode){
        if(node == null)
            return;
        boolean isLeaf = (node.left == null && node.right == null) ? true : false;
        if(!isLeaf) {
            addRightBoundaryNode( node.left,  node.right==null && isBoundaryNode); // left nodes will be a boundary only if there is no right node and its root is a boundary node. If it is not boundary then in recursion it is treated as boundary if it is a leaf node.
            addRightBoundaryNode( node.right, isBoundaryNode); //right nodes are always a boundary
        }
        //if its on boundary or if it is a leaf node then add it to result
        if(isBoundaryNode || isLeaf){
            answer.add(node.val);
        }
    }
}
