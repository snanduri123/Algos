/*
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.



Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []


Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000

 */


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTree_Nodes_K_Distance_863 {


    //DFS
    //Time:
    //Space:
    int total = 0;

    public int countPairs(TreeNode root, int distance) {

        getCountPairs( root,  distance);
        return total;
    }

    public Map<Integer, Integer> getCountPairs2(TreeNode root, int distance) {
        if (root == null) {
            return new HashMap<>();
        }
        Map<Integer, Integer> left = getCountPairs(root.left, distance);
        Map<Integer, Integer> right = getCountPairs(root.right, distance);
        for (Integer distLeft : left.keySet()) {
            for (Integer distRight : right.keySet()) {
                if (distLeft + distRight + 2 <= distance) {
                    total += left.get(distLeft) * right.get(distRight);
                }
            }
        }
        Map<Integer, Integer> retMap = new HashMap<>();
        for (Integer distLeft : left.keySet()) {
            retMap.put(distLeft + 1, retMap.getOrDefault(distLeft + 1, 0) + 1);
        }
        for (Integer distRight : right.keySet()) {
            retMap.put(distRight + 1, retMap.getOrDefault(distRight + 1, 0) + 1);
        }
        return retMap;
    }


    public Map<Integer, Integer> getCountPairs(TreeNode root, int distance) {

        if(root == null)
            return new HashMap<>();

        Map<Integer, Integer> leftDistNodesMap = getCountPairs( root.left,  distance);
        Map<Integer, Integer> rightDistNodesMap = getCountPairs( root.right,  distance);

        for(Integer leftDistance : leftDistNodesMap.keySet() ){
            for(Integer rightDistance : rightDistNodesMap.keySet() ){

                if(leftDistance + rightDistance + 2 <= distance){
                    total = total + leftDistNodesMap.get(leftDistance) * rightDistNodesMap.get(rightDistance);
                }
            }
        }

        Map<Integer, Integer> currDistNodesMap = new HashMap<>();

        if(leftDistNodesMap.size() ==0 && rightDistNodesMap.size() ==0){ //leaf node saying it is 1 distance from its parent
            currDistNodesMap.put(1,1);
        }

        for(Map.Entry<Integer,Integer> leftDistNodePair : leftDistNodesMap.entrySet()){
            currDistNodesMap.put(leftDistNodePair.getKey()+1, leftDistNodePair.getValue());
        }

        for(Map.Entry<Integer,Integer> rightDistNodePair : rightDistNodesMap.entrySet()){
            currDistNodesMap.put(rightDistNodePair.getKey()+1, currDistNodesMap.getOrDefault(rightDistNodePair.getKey()+1,0) +  rightDistNodePair.getValue());
        }


        return currDistNodesMap;

    }
        public static void main(String[] args) {
        BinaryTree_Nodes_K_Distance_863 b = new BinaryTree_Nodes_K_Distance_863();

//        /*
//                  1
//                /   \
//               2     3
//                \
//                 4
//         */
//
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(4);
        System.out.println( b.countPairs(node,3)); // 1 [3,4]

    }
}
