import java.util.ArrayList;
import java.util.List;

/*
                           10
               /                         \
              5                           15
        /         \                /             \
      3            8              12            17
    /   \        /   \
    2   4       7    9

   O/P 2 3 4 5 7 8 9 10 12 15 17

   left root right

   */
public class BinaryTree_InorderTraversal {

    List<Integer> values = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTravel(root);
        return values;
    }
    public void inorderTravel(TreeNode root){
        if(root == null)
            return;

        inorderTravel(root.left);
        values.add(root.val);
        inorderTravel(root.right);
    }

    public static void main(String args[]){

        TreeNode root = new TreeNode (10, null, null);
        root.left = new TreeNode (5, null, null);
        root.right = new TreeNode (15, null, null);
        root.left.left = new TreeNode (3, null, null);
        root.left.right = new TreeNode (8, null, null);
        root.right.left = new TreeNode (12, null, null);
        root.right.right = new TreeNode (17, null, null);
        root.left.left.left = new TreeNode (2, null, null);
        root.left.left.right = new TreeNode (4, null, null);
        root.left.right.left = new TreeNode (7, null, null);
        root.left.right.right = new TreeNode (9, null, null);
        print( root);

    }

    public static void print(TreeNode root){
        if(root == null){
            return;
        }
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }
}
