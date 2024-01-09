import java.util.*;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Example 1:
                  1
                /   \
               2     3
                   /    \
                  4      5


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000

 */
public class BinaryTree_Serialize_Deserialize_297 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        StringBuilder serializedString = new StringBuilder();
        if (root == null)
            return "null";

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                    serializedString.append(",");  //for top root also there is this extra comma, remove it later.
                    serializedString.append(node.val);
                } else {
                    serializedString.append(",null");
                }
            }
        }
        String s = serializedString.replace(0, 1, "").toString();  //remove the extra "," at the beginning of the string.
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<TreeNode> queue = new LinkedList<>();
        String[] arr = data.split(",");
        if (arr[0].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (i < arr.length && !arr[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(current.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    // Encodes a tree to a single string.
    public String serializeRecur(TreeNode root){
        if(root == null){
            return "null,";
        }

        StringBuilder ser  = new StringBuilder();
        ser.append(root.val);
        ser.append(",");
        ser.append(serializeRecur(root.left));
        ser.append(serializeRecur(root.right));

        return ser.toString();
    }

    // Decodes your encoded data to tree.
    public  TreeNode deserializeRecur(String ser){
        String[] toks = ser.split(",");
        return deserialization(toks, new int[]{0});
    }
    public  TreeNode deserialization(String[] ser, int[] offset){
        if(offset[0] >= ser.length || ser[offset[0]].trim().equals("null")){
            offset[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(ser[offset[0]++]));
        root.left = deserialization(ser, offset);
        root.right = deserialization(ser, offset);
        return root;
    }


    public static void main(String args[]) {

        BinaryTree_Serialize_Deserialize_297 B = new BinaryTree_Serialize_Deserialize_297();

        //  1.        /*
//                  1
//                /   \
//               2     3
//                   /    \
//                   4     5
//  O/P        [1,2,3,null,null,4,5]
//         */
//
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.right.left = new TreeNode(4);
        node1.right.right = new TreeNode(5);

        System.out.println(B.serialize(node1));
        TreeNode answer1 = B.deserialize(B.serialize(node1));
        System.out.println(answer1.val);

        //2.
        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);
        node2.right.left = new TreeNode(4);
        node2.right.right = new TreeNode(5);
        node2.right.left.left = new TreeNode(6);
        node2.right.left.right = new TreeNode(7);
        System.out.println(B.serialize(node2));
        TreeNode answer2 = B.deserialize(B.serialize(node2));
        System.out.println(answer2.val);


        //3
        TreeNode node3 = B.deserialize("4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2");
        String node3serialized = B.serialize(node3);
        System.out.println(node3serialized);

        //4.
        TreeNode answer4 = B.deserialize(B.serialize(null));
        //System.out.println(answer4.val);

    }

}
