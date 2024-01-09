/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]


Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n

 */

public class LinkedList_Reverse_LinkedList_II_92 {

   //TimeComplexity  - O(n)
    //Space complexity - O(1)
   public ListNode reverseBetween(ListNode head, int left, int right) {
       ListNode curr = head;
       ListNode start = null;
       ListNode prev = null;
       ListNode tail = null;
       int i= 1;
       while(start==null || tail==null){
           if(i == left){
               start = curr;
           }
           if(i == right){
               tail = curr.next;
               break;
           }
           if(start==null){
               prev = curr;
           }
           curr = curr.next;
           i++;
       }
       ListNode  rev = reverseList(start,tail);
       if(prev!= null) {
           prev.next = rev;
           return head;
       }
       return rev;
   }
    public ListNode reverseList(ListNode start, ListNode tail){
        ListNode prev = start;
        ListNode curr = start.next;
        prev.next = null;
        while(curr != tail){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        start.next = tail;
        return prev;
    }

    public static void main(String[] args) {
        LinkedList_Reverse_LinkedList_II_92 r = new LinkedList_Reverse_LinkedList_II_92();

        //LinkedList: 1->2->3->4->5
//        ListNode node1 = new ListNode(1);
//        node1.next = new ListNode(2);
//        node1.next.next  = new ListNode(3);
//        node1.next.next.next  = new ListNode(4);
//        node1.next.next.next.next  = new ListNode(5);
//        ListNode ans ;
//        ans =r.reverseBetween(node1, 2, 4);  // 1--->4--->3--->2--->5
//        ListNode.printAllNodes(ans);

        //LinkedList: 1->2->3->4->5
        ListNode node2 = new ListNode(1);
        ListNode ans2 ;
        ans2 =r.reverseBetween(node2, 1, 1);  // 1--->4--->3--->2--->5
        ListNode.printAllNodes(ans2);
    }
}
