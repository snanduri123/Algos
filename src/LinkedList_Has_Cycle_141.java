public class LinkedList_Has_Cycle_141 {

   //TimeComplexity  - O(n)
    //Space complexity - O(1)
    //The slow pointer moves one step at a time while the fast pointer moves two steps at a time.
   public boolean hasCycle(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
           if (slow == fast)  //after some time slow meets faster if it is cyclic.
               return true;
       }
       return false;
   }
}
