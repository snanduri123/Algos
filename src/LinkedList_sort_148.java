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

public class LinkedList_sort_148 {

    //TimeComplexity  - O(n)
    //Space complexity - O(1)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    public ListNode getMid(ListNode head) {
        // ListNode slow = head;
        // ListNode fast = head;
        // while(fast!=null && fast.next!=null){
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }

        // return slow;
        int len = 0;
        ListNode curr = head;

        //find len
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        //find mid and sec half head;
        int mid = len % 2 == 0 ? len / 2 : (len / 2) + 1;
        curr = head;
        int i = 0;
        while (i < mid) {
            curr = curr.next;
            i++;
        }
        return curr;
    }

    public static void main(String[] args) {
        LinkedList_sort_148 r = new LinkedList_sort_148();

        //LinkedList: 1->2->3->4
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        r.sortList(node1);
        ListNode.printAllNodes(node1); // 1--->4--->2--->3

        //LinkedList: 1->2->3->4->5
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);
        node2.next.next.next.next = new ListNode(5);
        r.sortList(node2);  // 1--->4--->2--->3--->5
        ListNode.printAllNodes(node2);

        //LinkedList: 1
        ListNode node3 = new ListNode(1);
        r.sortList(node3);  // 1
        ListNode.printAllNodes(node3);
    }
}
