public class Middle_Of_LinkedList_876 {
//Given a non-empty, singly linked list with head node head, return a middle node of linked list.
//
//If there are two middle nodes, return the second middle node.

    //Time complexity : n or n + n = 2n (n nodes traversing for counting + n nodes to traverse to the middle Eg if there are only 2 nodes)
    //Space complexity : constant
    public static void main(String[] args) {

        //odd
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);


        //even
        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(2);
        n2.next.next = new ListNode(3);
        n2.next.next.next = new ListNode(4);
        n2.next.next.next.next = new ListNode(5);
        n2.next.next.next.next.next = new ListNode(6);


        int val;

        val = middleNode(n).val;
        System.out.println("node " + val);

        val = middleNode(n2).val;
        System.out.println("node " + val);


    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null)
            return head.next;

        int count = 0;

        ListNode rootNode = head;

        while (head != null) {
            head = head.next;
            count++;
        }


        count = (count / 2) + 1; // 5/2 is 2 , so to get 3 we add 1. 6/2 is 3 but for even we want second middle node which is 4, so again we add 1.


        System.out.println("middle num is " + count);

        int idx = 1;
        head = rootNode; //important step. Because we already iterated and head has become null.
        while (idx < count) {
            head = head.next;
            idx++;
        }
        return head;
    }
}
