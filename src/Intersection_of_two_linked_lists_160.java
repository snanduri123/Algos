/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

Custom Judge:

The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.



Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
Example 2:


Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.


Constraints:

The number of nodes of listA is in the m.
The number of nodes of listB is in the n.
1 <= m, n <= 3 * 104
1 <= Node.val <= 105
0 <= skipA < m
0 <= skipB < n
intersectVal is 0 if listA and listB do not intersect.
intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.


Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
 */

public class Intersection_of_two_linked_lists_160 {


//    //Time:  To find length : O(A) + O(B)
//    //       To skip the nodes: O(A) or O(B)
//    //       To find the interception: O(A) + O(B)
//    // Total time = 3(O(A) +O(B))
//    //Space: O(1)
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//        if(headA == headB || headA==null || headB==null)
//            return headA;
//
//        ListNode nodeA = headA;
//        ListNode nodeB = headB;
//
//        int lenA =0;
//        int lenB = 0;
//        int diff=0;
//
//        //calculate len of listA
//        while(nodeA!=null){
//            lenA++;
//            nodeA = nodeA.next;
//        }
//
//        //calculate len of listB
//        while(nodeB!=null){
//            lenB++;
//            nodeB = nodeB.next;
//        }
//
//        diff = Math.abs(lenA - lenB);
//        int i=1;
//
//        nodeA = headA;
//        nodeB = headB;
//
//        //skip the nodes in listA to the place where listA and listB length are equal
//        if(lenA > lenB){
//            while(i <= diff) {
//                nodeA = nodeA.next;
//                i++;
//            }
//        }
//        else{
//            while(i <= diff) {
//                nodeB = nodeB.next;
//                i++;
//            }
//        }
//
//        while(nodeA!=null){
//            if(nodeA == nodeB)
//                return nodeA;
//            else {
//                nodeA = nodeA.next;
//                nodeB = nodeB.next;
//            }
//        }
//        return null;
//    }


    public ListNode getIntersectionNode(ListNode l1, ListNode l2){

        if(l1 == null || l2 == null)
            return null;

        ListNode l1Start = l1;
        ListNode l2Start = l2;

        int len1 = length(l1Start);
        int len2 = length(l2Start);

        int diff = Math.abs(len1 - len2);

        l1Start = l1;
        l2Start = l2;

        if(len1 > len2)
        {
            l1Start = skipNodes(l1Start, diff);
        }

        else if (len2 > len1) {
            l2Start = skipNodes(l2Start, diff);
        }

        while(l1Start !=null && l2Start!=null)
        {
            if(l1Start == l2Start)
                return l1Start;
            else
            {
                l1Start = l1Start.next;
                l2Start = l2Start.next;
            }
        }

        return null;
    }

    public int length(ListNode l){
        int len = 0;
        while(l !=null){
            len++;
            l = l.next;
        }

        return len;
    }

    public ListNode skipNodes(ListNode l, int len) {
        int skip = 1;
        while(skip <= len){
            l = l.next;
            skip++;
        }
        return l;
    }

    public static void main(String[] args){
        Intersection_of_two_linked_lists_160 i = new Intersection_of_two_linked_lists_160();

        //1. intersected at 8
        //  [4,1,8,4,5]
        //[5,6,1,8,4,5]
        /*
                4  1
                      8 4 5
             5  6  1

         */

        ListNode intersectNode = new ListNode(8,null);
        intersectNode.next = new ListNode(4,null);
        intersectNode.next.next = new ListNode(5,null);

        ListNode l1 = new ListNode(4,null);
        l1.next = new ListNode(1, null);
        l1.next.next = intersectNode;

        ListNode l2 = new ListNode(5,null);
        l2.next = new ListNode(6, null);
        l2.next.next = new ListNode(1, null);
        l2.next.next.next = intersectNode;



        System.out.println(i.getIntersectionNode(l1, l2).val);
    }
}
