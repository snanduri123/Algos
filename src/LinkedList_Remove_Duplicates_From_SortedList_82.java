/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.



Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]


Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

 */

public class LinkedList_Remove_Duplicates_From_SortedList_82 {

   //TimeComplexity  - O(n)
    //Space complexity - O(1)
   public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1); //sentinel node
        dummy.next = head;   //attach to given head;
        ListNode tail = dummy;
        ListNode curr = head;
        while(curr!=null){
            while(curr.next!=null && curr.val == curr.next.val){ //remove duplicates
                curr = curr.next;
            }
            if(tail.next==curr){  //if tail.next is pointing to curr and curr node also stayed at same place then that means there were no duplicates, so make curr as tail
                tail = curr; //or tail = tail.next;
            } else{  //if there were duplicates then curr has moved to last of its duplicate    and next is new element so attach the new element to tail (to skip all the duplicates in between)
                tail.next=curr.next;
            }
            curr=curr.next; //go to the next new element (which may have duplicates and all will be skipped in next iteration)
        }
    return dummy.next;
   }

    public static void main(String[] args) {
        LinkedList_Remove_Duplicates_From_SortedList_82 r = new LinkedList_Remove_Duplicates_From_SortedList_82();

        //LinkedList: 1->1->1->2->2->2->3->4->4->5
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next  = new ListNode(1);
        node.next.next.next  = new ListNode(2);
        node.next.next.next.next  = new ListNode(2);
        node.next.next.next.next.next  = new ListNode(2);
        node.next.next.next.next.next.next  = new ListNode(3);
        node.next.next.next.next.next.next.next  = new ListNode(4);
        node.next.next.next.next.next.next.next.next  = new ListNode(4);
        node.next.next.next.next.next.next.next.next.next  = new ListNode(5);

        ListNode ans ;
        ans =r.deleteDuplicates(node);  // 3->5
        ListNode.printAllNodes(ans);


        //LinkedList: 1->1->1->2->2->2->3->4->4->5
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(1);
        node2.next.next  = new ListNode(1);
        node2.next.next.next  = new ListNode(2);
        node2.next.next.next.next  = new ListNode(3);
        node2.next.next.next.next.next  = new ListNode(3);
        node2.next.next.next.next.next.next  = new ListNode(3);
        node2.next.next.next.next.next.next.next  = new ListNode(4);
        node2.next.next.next.next.next.next.next.next  = new ListNode(4);
        node2.next.next.next.next.next.next.next.next.next  = new ListNode(5);

        ListNode ans2 ;
        ans2 =r.deleteDuplicates(node2);  // 2->5
        ListNode.printAllNodes(ans2);

    }
}
