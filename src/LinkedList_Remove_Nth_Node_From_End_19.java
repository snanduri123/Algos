public class LinkedList_Remove_Nth_Node_From_End_19 {

   //TimeComplexity  - O(n)
    //Space complexity - O(1)
   public ListNode removeNthFromEnd(ListNode head, int n) {
       int len =0;
       ListNode curr = head;
       while(curr!= null){
           curr = curr.next;
           len++;
       }
        System.out.println("len " + len);
       if(n==len) //remove last element from end (i.e., first node)
           return head.next;
       int pos = len - n;
       System.out.println("idx to remove from start " + pos);
       ListNode prev = null;
       curr = head;
       int i = 0;
       while(i < pos){  // move until after pos, so that curr point to node next to pos.
           prev = curr;
           curr = curr.next;
           i++;
       }
       prev.next = curr.next;
       return head;
   }

    public static void main(String[] args) {
        LinkedList_Remove_Nth_Node_From_End_19 r = new LinkedList_Remove_Nth_Node_From_End_19();

        //LinkedList: 1->2->3->4->5
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next  = new ListNode(3);
        node.next.next.next  = new ListNode(4);
        node.next.next.next.next  = new ListNode(5);
        ListNode ans ;
        ans =r.removeNthFromEnd(node, 2);
        ListNode.printAllNodes(ans);
    }
}
