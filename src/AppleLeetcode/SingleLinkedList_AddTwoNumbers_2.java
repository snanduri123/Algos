package AppleLeetcode;
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */

public class SingleLinkedList_AddTwoNumbers_2 {

    //Time : O(m) + O(n)
    //Space: O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyhead = new ListNode(-1); //dummyhead
        ListNode curr = dummyhead;
        int carry = 0;
        while(l1 != null || l2!=null || carry !=0){

            int digit1 = (l1 !=null)? l1.val : 0;
            int digit2 = (l2 !=null)? l2.val : 0;

            int sum = digit1 + digit2 + carry;

            int newDigit = sum%10;
            carry = sum/10;

            ListNode node = new ListNode(newDigit);
            curr.next = node;
            curr = node;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return dummyhead.next;
    }


}
