/*
Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.



Example 1:


Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]
Example 2:


Input: root = [2,1,1]
Output: [[1]]
Example 3:


Input: root = [2,2,2,3,null,3,null]
Output: [[2,3],[3]]


Constraints:

The number of the nodes in the tree will be in the range [1, 5000]
-200 <= Node.val <= 200
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTree_Find_Duplicate_Subtrees_652 {
    HashMap<String, Integer> treeCodeIdentifierMap;  //current tree's code and its identifier. code is leftSubtreeCode + rootval + rightSubtreeCode. Identifier is just a unique number starting from 1, to identify the code.
    HashMap<Integer, Integer> IdentifierFoundCountMap; //Identifier and how many duplicates we have seen. To track an identifier (maps to treecode from above map) seen more than 1 time  (2 or more duplicates)
    List<TreeNode> answer;

    //Time: O(n) We traverse the tree with n nodes and, for each subtree, find a triplet and an ID.
    // We perform operations with the hash maps tripletCodeToID and cnt.
    // Since an ID is an integer and a tripletCode has a length of 3 (O(1)), these operations take O(1) time for each of the n nodes.

    //Spae: O(n): We store the hash maps tripletToID and cnt, which take O(n) memory.
    //      Also, the recursion stack takes O(n) memory
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        answer = new ArrayList<>();
        treeCodeIdentifierMap = new HashMap<>();
        IdentifierFoundCountMap = new HashMap<>();

        findDuplicates(root);
        return answer;
    }


    public int findDuplicates(TreeNode root) {
        if (root==null)
            return 0;

        int leftIdentifier  = findDuplicates(root.left);
        int rightIdentifier = findDuplicates(root.right);

        String treeCode = leftIdentifier + "," + root.val + "," + rightIdentifier; //leaf node's tree code will be 0,leafVal,0.

        if(!treeCodeIdentifierMap.containsKey(treeCode)){
            treeCodeIdentifierMap.put(treeCode, treeCodeIdentifierMap.size() + 1); //the identifier value has to be unique so we go by size of the map.
        }
        Integer currIdentifier = treeCodeIdentifierMap.get(treeCode);

        //add identifier or update its count
        IdentifierFoundCountMap.put(currIdentifier, IdentifierFoundCountMap.getOrDefault(currIdentifier,0) + 1);
        int treeCodeFoundCount = IdentifierFoundCountMap.get(currIdentifier);

        if(treeCodeFoundCount == 2){  //even if we see > 2 times, since duplicate is captured we don't capture it in the result again.
            answer.add(root);
        }

        return currIdentifier;
    }

    public static void main(String[] args) {
        BinaryTree_Find_Duplicate_Subtrees_652 b = new BinaryTree_Find_Duplicate_Subtrees_652();

        /*
                  1
                /   \
               2@     3
             /  \    /  \
            4@    2 2@    4@
                   /
                  4@
            O/P  : duplicate nodes @ : 2 and 4 --> paths are [[2,4],[4]]
         */

        TreeNode node = new TreeNode(1); //7. treeCode : 2,1*,3 and identifier = 2
        node.left = new TreeNode(2);  //2. treeCode : 1,2*,0 and identifier = 2 , count = 1
        node.right = new TreeNode(3); //6. treeCode : 2,3*,1 and identifier = 3
        node.left.left = new TreeNode(4);  //1. treeCode : 0,4*,0 and identifier = 1, count = 1
        node.right.left = new TreeNode(2);  //4. treeCode : 1,2,0 because it is already found with identifier 2, its count becomes 2 and is noted as duplicate
        node.right.right = new TreeNode(4);  //5. treeCode : 0,4*,0 because it is already found twice with identifier 1, its count still remain twice.
        node.right.left.left = new TreeNode(4); //3. treeCode : 0,4*,0 because it is already found with identifier 1, its count becomes 2 and is noted as duplicate

        List<TreeNode> nodes = b.findDuplicateSubtrees(node);
    //        List<nodes.stream().map(e -> e.val).collect(Collectors.toList());
    //    System.out.println(  b.findDuplicateSubtrees(nodes));


    }
}
