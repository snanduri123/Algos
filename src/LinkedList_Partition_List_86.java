/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.



Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]


Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
 */


public class LinkedList_Partition_List_86 {

    public ListNode partition(ListNode head, int x) {
        ListNode leftPartition = new ListNode(-1);  //leftPartition (all nodes <  k)
        ListNode leftPartitionHead = leftPartition;
        ListNode rightPartition = new ListNode(-1);  //rightPartition (all nodes > k)
        ListNode rightPartitionHead = rightPartition;
        ListNode curr = head;
        while(curr != null){
            if(curr.val < x){
                leftPartition.next = curr;
                leftPartition = curr;
            }else {
                rightPartition.next = curr;
                rightPartition = curr;
            }
            curr = curr.next;
        }

        rightPartition.next = null;
        leftPartition.next = rightPartitionHead.next; // rightpartion head(avoid dummy) is attached to leftpartition
        return leftPartitionHead.next;
    }
}
