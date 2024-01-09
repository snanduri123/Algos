/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]


Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000

 */

public class LinkedList_Reorder_143 {

   //TimeComplexity  - O(n)
    //Space complexity - O(1)
   public void reorderList(ListNode head) {
       int len = 0;
       ListNode curr = head;

       //find len
       while(curr!=null){
           curr = curr.next;
           len++;
       }

       //if only 2 nodes then no need to do anything. Just return.
       if(len <= 2){
           return;
       }

       //find mid and sec half head;
       int mid = len%2 ==0 ? len/2 : (len/2) + 1;
       curr = head;
       int i = 0;
       while(i < mid){
           curr = curr.next;
           i++;
       }
       ListNode head2 = curr;

       //reverse head2
       ListNode prev = head2;
       curr = head2.next;
       prev.next = null;
       while(curr!=null){
           ListNode next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       // connect each node alternatively from list1 and list2
       head2 = prev;
       ListNode head1 = head;
       while(head2 !=null){
           ListNode next1 = head1.next;
           ListNode next2 = head2.next;
           head1.next = head2;
           head2.next = next1;
           head1 = next1;
           head2 = next2;
       }
       head1.next = null;  //head1 points to the now last element (also the last element of first half), so its next should be null.
   }

    public static void main(String[] args) {
        LinkedList_Reorder_143 r = new LinkedList_Reorder_143();

        //LinkedList: 1->2->3->4
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next  = new ListNode(3);
        node1.next.next.next  = new ListNode(4);
        r.reorderList(node1);
        ListNode.printAllNodes(node1); // 1--->4--->2--->3

        //LinkedList: 1->2->3->4->5
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next  = new ListNode(3);
        node2.next.next.next  = new ListNode(4);
        node2.next.next.next.next  = new ListNode(5);
        r.reorderList(node2);  // 1--->4--->2--->3--->5
        ListNode.printAllNodes(node2);

        //LinkedList: 1
        ListNode node3 = new ListNode(1);
        r.reorderList(node3);  // 1
        ListNode.printAllNodes(node3);
    }
}
