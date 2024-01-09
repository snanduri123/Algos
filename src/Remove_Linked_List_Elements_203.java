public class Remove_Linked_List_Elements_203 {
    public static void main(String[] args) {


        ListNode head =  new ListNode(1);
        ListNode.printAllNodes(removeElements( head, 1));
    }

    public static ListNode removeElements(ListNode head, int val) {


        if (head.val == val) {
            return null;
        }

        ListNode prev = head;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                if (head == curr) {
                    head = curr.next;
                    prev = head;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }


}
