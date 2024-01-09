/*
Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).



Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]


Constraints:

The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 104]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.
class TNode {
    public int val;
    public List<TNode> children;

    public TNode() {}

    public TNode(int _val) {
        val = _val;
    }

    public TNode(int _val, List<TNode> _children) {
        val = _val;
        children = _children;
    }
};

public class BinaryTree_NArr_LevelOrder_Traversal_429 {

    public List<List<Integer>> levelOrder(TNode root) {
        Queue<TNode> queue = new LinkedList<>();
        List<List<Integer>> answer = new LinkedList<List<Integer>>();

        if(root == null) return answer;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i =0; i < levelNum; i++){
                TNode node = queue.poll();
                for(TNode child :  node.children) {
                    queue.offer(child);
                }
                subList.add(node.val);
            }
            answer.add(subList);
        }
        return answer;
    }

    public Integer find_Edges(TNode root) { //not height

        if(root == null){
            return 0;
        }

        if(root.children == null){
            return 0;
        }

        int maxChildHeight = 0;
        for(TNode child : root.children){
            maxChildHeight = Math.max(maxChildHeight,find_Edges( child));
        }
        return maxChildHeight + 1;
    }


    public static void main(String[] args){
        BinaryTree_NArr_LevelOrder_Traversal_429 b = new BinaryTree_NArr_LevelOrder_Traversal_429();
        // 1.
//                      1
//                  /   \  \
//                 2     3  4
//               /   \   \   \
//              4     5  6    7
//            /      /
//           8      9
//
//       8, 4, 2, 5, 9 is the longest path and has 5 nodes and 4 edges and does not go through root.

        Integer arr1[] = {1, 2, 3, 4, 5, null, null, 8, null, 9, null};
        TNode root1 = new TNode();
        root1 = new TNode(1);

        List<TNode> children = new ArrayList<>();
        children.add(new TNode(2));
        children.add(new TNode(3));
        children.add(new TNode(4));
        root1.children = children;


        List<TNode> children2 = new ArrayList<>();
        children2.add(new TNode(4));
        children2.add(new TNode(5));
        root1.children.get(0).children = children2;

        List<TNode> children3 = new ArrayList<>();
        children3.add(new TNode(8));
        root1.children.get(0).children.get(0).children = children3;

        System.out.println(b.find_Edges(root1)); //4

    }
}
