public class Remove_Duplicates_from_SortedList_83 {

    public ListNode deleteDuplicates1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode next = curr.next;

        while (next != null) {
            if (curr.val == next.val) {
                curr.next = next.next;
            } else {
                curr = curr.next;
            }
            next = next.next;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head != null) {
            ListNode curr = head;
            ListNode next = null;

            while (curr!=null  && curr.next != null) {
                next = curr.next;
                if (curr.val == next.val) {
                    curr.next = next.next;
                } else {
                    curr = next;
                }
            }
        }
        return head;
    }

    public static void main(String args[]) {

        Remove_Duplicates_from_SortedList_83 P = new Remove_Duplicates_from_SortedList_83();

        //1->1->2   ---> 1->2
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);

        ListNode.printAllNodes(P.deleteDuplicates(node));

        //1->2   ---> 1->2
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(1);
        node2.next.next = new ListNode(2);

        ListNode.printAllNodes(P.deleteDuplicates(node2));

        //[1,1,2,3,3] --> 1,2,3
        ListNode node3 = new ListNode(1);
        node3.next = new ListNode(1);
        node3.next.next = new ListNode(2);
        node3.next.next.next = new ListNode(3);
        node3.next.next.next.next = new ListNode(3);

        ListNode.printAllNodes(P.deleteDuplicates(node3));

        //1->1->1   ---> 1
        ListNode node4 = new ListNode(1);
        node4.next = new ListNode(1);
        node4.next.next = new ListNode(1);

    }
}
