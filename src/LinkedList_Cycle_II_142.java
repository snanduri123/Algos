/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.



Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.


Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.


Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */

public class LinkedList_Cycle_II_142 {

   //TimeComplexity  - O(n)
    //Space complexity - O(1)
    //The slow pointer moves one step at a time while the fast pointer moves two steps at a time.
   public ListNode detectCycle(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       while(fast!=null && fast.next!=null){
           slow  = slow.next;
           fast = fast.next.next;
           if(slow == fast){
               break;
           }
       }
       if(fast == null || fast.next == null){ //no cycle
           return null;
       }
       //Reset either slow or fast pointer to head
       fast = head;
       //Move both pointers one step until they meet again
       while(slow != fast){
           slow =slow.next;
           fast = fast.next;
       }
       return slow;  //or fast
   }

    public static void main(String[] args) {
        LinkedList_Cycle_II_142 l = new LinkedList_Cycle_II_142();
        //LinkedList: 1->2->3->2->1 (palindrome)
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2,node1);
        System.out.println(l.detectCycle(node1).val);
    }
}
