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
public class BinaryTree_DistributeCoins_979 {

    //Time: O(n)
    //Space: O(n) - stack
    int distributionsNeeded;
    public int distributeCoins(TreeNode root) {
        distributionsNeeded = 0;
        distributeMyCoins(root);
        return distributionsNeeded;
    }
    public int distributeMyCoins(TreeNode root) {
        if (root == null) {
            return 0; //no distribution needed.
        }

        //one side may have extra coins to distribute and other side may be deficit of coins
        // i.e, get distributed or both sides are deficit or both sides have extra or
        // both sides have 1 coin.
        int LExtraOrDeficitCoins = distributeMyCoins(root.left);
        int RExtraOrDeficitCoins = distributeMyCoins(root.right);

        distributionsNeeded += Math.abs(LExtraOrDeficitCoins) + Math.abs(RExtraOrDeficitCoins);

        // if left, root and right have 1 coin each then LExtraOrDeficitCoins = 0 and RExtraOrDeficitCoins = 0 and
        // hence this root does not need coins to get from or give to its parent (distribution is 0)
        return (LExtraOrDeficitCoins + root.val + RExtraOrDeficitCoins) - 1;
    }


    public static void main(String args[]) {

        BinaryTree_DistributeCoins_979 b = new BinaryTree_DistributeCoins_979();

        TreeNode root = new TreeNode(3, null, null);
        root.left = new TreeNode(0, null, null);
        root.right = new TreeNode(0, null, null);
        b.distributeCoins(root);
        System.out.println(b.distributionsNeeded);


        TreeNode root2 = new TreeNode(0, null, null);
        root2.left = new TreeNode(3, null, null);
        root2.right = new TreeNode(0, null, null);
        b.distributeCoins(root2);
        System.out.println(b.distributionsNeeded);
    }
}
