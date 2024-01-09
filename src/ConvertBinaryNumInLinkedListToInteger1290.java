/*
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

The most significant bit is at the head of the linked list.



Example 1:


Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:

Input: head = [0]
Output: 0


Constraints:

The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.
 */

//Time : O(2n)
//Space : O(K)
public class ConvertBinaryNumInLinkedListToInteger1290 {

    public int getDecimalValue(ListNode head) {

        //reverse the LinkedList
        ListNode prev = head;
        ListNode curr = prev.next;
        prev.next = null;    //important step. Otherwise it will be cyclic.
        ListNode next = null;
        int len = 0;  // if there are 3 nodes then length will be 2.

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            len++;
        }

        //convert the list to binary.
        int exponent = 0;
        double num = 0;
        while(exponent <= len){   //the position(length) of the node will determine the exponent to be used.
            num = num + (prev.val * Math.pow(2, exponent));
            prev = prev.next;
            exponent++;
        }

        return (int)num;
    }


    public static void main(String[] args){
        ConvertBinaryNumInLinkedListToInteger1290 c = new ConvertBinaryNumInLinkedListToInteger1290();
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(0);
        n1.next.next = new ListNode(1);
        System.out.println(c.getDecimalValue(n1)); //101 --> 5
    }
}
