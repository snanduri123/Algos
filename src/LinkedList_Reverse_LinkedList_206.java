public class LinkedList_Reverse_LinkedList_206 {

    public static void main(String[] args) {
        LinkedList_Reverse_LinkedList_206 r = new LinkedList_Reverse_LinkedList_206();

        //LinkedList: 1->2->3->2->1 (palindrome)
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next  = new ListNode(3);
        node.next.next.next  = new ListNode(2);
        node.next.next.next.next  = new ListNode(1);

        //odd number
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next  = new ListNode(3);
        node2.next.next.next  = new ListNode(4);
        node2.next.next.next.next  = new ListNode(5);


        //even number
        ListNode node3 = new ListNode(1);
        node3.next = new ListNode(2);
        node3.next.next  = new ListNode(3);
        node3.next.next.next  = new ListNode(4);

        ListNode ans ;

        ans =r.reverseList(node);
        ListNode.printAllNodes(ans);

        ans = r.reverseList(node2);
        ListNode.printAllNodes(ans);

        ans = r.reverseList(node3);
        ListNode.printAllNodes(ans);

    }

    //TimeComplexity - O(n);
    //Space complexity - constant;
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = head;
        head = head.next;
        prev.next = null;  //important step to make linkedlist non cyclic.

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;

    }

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode prev = head;
        ListNode curr = prev.next;
        prev.next = null; //important step to make linkedlist non cyclic.

        while(curr!=null)
        {
            ListNode temp  = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
