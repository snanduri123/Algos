//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
public class Merge_Two_Sorted_Linked_Lists_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null;
        ListNode prev = null;
        ListNode next1 = null;
        ListNode next2 = null;
        if(list1.val < list2.val){
            head = list1;
            prev = list1;
            next1 = list1.next;
            next2 = list2;
        }
        else{
            head = list2;
            prev = list2;
            next1 = list1;
            next2 = list2.next;
        }

        while(next1!=null && next2 !=null){
            if(next1.val < next2.val){
                prev.next = next1;
                prev = next1;
                next1 = next1.next;
            }
            else{
                prev.next = next2;
                prev = next2;
                next2 = next2.next;
            }
        }

        if((next1 == null) && (next2 !=null))
            prev.next = next2;
        else if ((next2 == null) && (next1 !=null))
            prev.next = next1;

        return head;

    }

}
