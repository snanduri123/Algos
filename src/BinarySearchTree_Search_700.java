

public class BinarySearchTree_Search_700 {

    //Time: O(logn) in best case / O(N) worst case - height of the tree
    //Space: O(logn) in best case / O(N) worst case - height of the tree
    public TreeNode searchBST(TreeNode root, int val) {

        if(root == null)
            return null;

        if(root.val == val)
            return root;

        if(val < root.val)
            return  searchBST(root.left, val);
        else
            return  searchBST(root.right, val);

    }


    public static void main(String[] args) {

        BinarySearchTree_Search_700 b = new BinarySearchTree_Search_700();

        Integer arr1[] = {4,2,7,1,3};
        TreeNode root1 = new TreeNode();
        root1 = TreeNode.insertLevelOrder(arr1, root1, 0);

        System.out.println(b.searchBST(root1,2).val);

    }
}
