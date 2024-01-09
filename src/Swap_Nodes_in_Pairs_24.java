public class Swap_Nodes_in_Pairs_24 {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        ListNode.printAllNodes(swapPairs(head));
//
//        System.out.println("        ");
//
//        ListNode head2 = new ListNode(1);
//        head2.next = new ListNode(2);
//        head2.next.next = new ListNode(3);
//        head2.next.next.next= new ListNode(4);
//        ListNode.printAllNodes(swapPairs(head2));
//
//        System.out.println("        ");
//
//        ListNode head3 = new ListNode(1);
//        head3.next = new ListNode(2);
//        head3.next.next = new ListNode(3);
//        head3.next.next.next= new ListNode(4);
//        head3.next.next.next.next= new ListNode(5);
//        ListNode.printAllNodes(swapPairs(head3));
//
//        System.out.println("        ");

        //2,5,3,4,6,2,2
        ListNode head4 = new ListNode(2);
        head4.next = new ListNode(5);
        head4.next.next = new ListNode(3);
        head4.next.next.next= new ListNode(4);
        head4.next.next.next.next= new ListNode(6);
        head4.next.next.next.next.next= new ListNode(2);
        head4.next.next.next.next.next.next= new ListNode(2);
        ListNode.printAllNodes(swapPairs(head4));

    }

    public static ListNode swapPairs(ListNode head) {

        if(head==null || head.next == null){
            return head;
        }
        ListNode prev = head;
        head = head.next;
        ListNode curr = head.next;
        head.next = prev;
        ListNode next;
        ListNode nextCurr;
        prev.next = curr;

        while(curr!=null && curr.next!=null){
            next = curr.next;

            nextCurr = next.next;

            //swap nodes of the pair. curr is first node and next is second node
            curr.next = next.next;
            next.next = curr;

            //connecting old pair's end node to new pair's starting node
            prev.next = next;

            //identify what is the new end node of the current pair
            prev = curr;

            //identiy next curr i.e, starting node of next pair
            curr = nextCurr;

        }
     return head;
    }
}


