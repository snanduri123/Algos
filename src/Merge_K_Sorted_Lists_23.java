/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 */


import java.util.Arrays;
import java.util.PriorityQueue;

public class Merge_K_Sorted_Lists_23 {


    //Time : O(N*mlog{k*m}) //m is number of integers in each list and n is the no of lists.
    //Space: O(n) //all nodes of all lists are stored in PQ.  Fastest.
    public ListNode mergeKLists(ListNode[] lists){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(ListNode listNode : lists){

            while(listNode != null) {
                pq.add(listNode.val);
                listNode = listNode.next;
            }
        }

        ListNode ansHead = null;
        ListNode curr = null;


        while(!pq.isEmpty()){
            int num = pq.poll();
            if(ansHead == null){
                ansHead = new ListNode(num);
                curr = ansHead;
            }else{
                curr.next = new ListNode(num);
                curr = curr.next;
            }
        }
        return ansHead;
    }


    //Time : O(k * O(m+n)) = O(kn)  --> k is the size of the list
    //Space: O(1)
    public ListNode mergeKLists_comparison(ListNode[] lists){

        if(lists.length == 0){
            return null;
        }
        ListNode prevList = lists[0];
        for(int i = 1; i < lists.length; i++){
          prevList =   mergeTwoLists_inPlace(prevList, lists[i]);
        }
        return prevList;
    }


    //Time : O(m + n)
    //Space: O(1)  //l1 is only updated.
    public ListNode mergeTwoLists_inPlace(ListNode l1, ListNode l2){

        if(l1 == null)
            return l2;

        if(l2 == null)
            return l1;

        //use two pointers (like in merge sort)
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode ansHead;

        if(l1.val < l2.val) {
            ansHead = l1;
            p1 = p1.next;
        }
        else {
            ansHead = l2;
            p2 = p2.next;
        }

        ListNode curr = ansHead;


        while(p1 != null && p2!=null) {
            if (p1.val < p2.val) {
                curr.next = p1;
                p1 = p1.next;
            }else{
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }

        if(p1 !=null){
            curr.next = p1; //if there are still list1 elements then add them to the temp using their curr pointer.
        }

        if(p2 !=null){
            curr.next = p2; //if there are still list1 elements then add them to the temp using their curr pointer.
        }

        return ansHead; //because there is -1 in the beginning.
    }


    //Time : O(m + n)
    //Space: O(m + n) //new list is created.
    public ListNode mergeTwoLists_In_NewList(ListNode l1, ListNode l2){

        ListNode temp = new ListNode(-1);  //just to create answer list,
        ListNode tempHead = temp;                   //adding a node with dummy value -1. Remove it before returning answer

        //use two pointers (like in merge sort)
        ListNode p1 = l1;
        ListNode p2 = l2;

        while(p1 != null && p2!=null) {
            if (p1.val < p2.val) {
                temp.next = p1;
                p1 = p1.next;
            }else{
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }

        if(p1 !=null){
            temp.next = p1; //if there are still list1 elements then add them to the temp using their curr pointer.
        }

        if(p2 !=null){
            temp.next = p2; //if there are still list1 elements then add them to the temp using their curr pointer.
        }

        return tempHead.next; //because there is -1 in the beginning.
    }

    public static void main(String[] args){

        Merge_K_Sorted_Lists_23 m = new Merge_K_Sorted_Lists_23();


        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);

        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);

        ListNode[] lists = new ListNode[] {n1, n2, n3};

        ListNode.printAllNodes((m.mergeKLists(lists)));  //1--->1--->2--->3--->4--->4--->5--->6--->
    }
}
