//LinkedList: 1->2->3->2->1

///Test {1,1,1} -- true
//2. {1} - true
//3. {1,2,3,2,1} --true
//4. {1,2,2,1} - true
//5. null - true
//6. {1,2,1,2} -- false
//7. {1,2,3,1,2} -- false

public class Palindrome_Single_LinkedList_234 {

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Palindrome_Single_LinkedList_234 P = new Palindrome_Single_LinkedList_234();
        //1. LinkedList: 1->2->3->2->1 (palindrome odd)
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(1);

        System.out.println(P.isPalindrome(node)); //true

        //2. LinkedList: 1->2->2->1 (palindrome even)
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(2);
        node2.next.next.next = new ListNode(1);
        System.out.println(P.isPalindrome(node2)); //true

        //3. LinkedList: 1 (palindrome only one element)
        ListNode node4 = new ListNode(1);
        System.out.println(P.isPalindrome(node4)); //true

        //4. LinkedList: 1->2->3->1 (not palindrome)
        ListNode node3 = new ListNode(1);
        node3.next = new ListNode(2);
        node3.next.next = new ListNode(3);
        node3.next.next.next = new ListNode(1);
        System.out.println(P.isPalindrome(node3)); //false
    }

    //using slow and fast pointer to find the second half of the list
    //Time : O(n)
    //Space: O(1)
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){  // In case of even numbers fast becomes null and slow points at the starting of second half. Eg: 1 2 2 1 --> slow will point at second 2.
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secHalfHead = (fast==null) ? slow : slow.next;

        //reverse the second half of the list. First half may be bigger than second half in the case of odd count in the input.
        //Eg: Input : 1 2 3 2 1 --> firstHalf: 1 2 3 and secondHalf: 2 1
        ListNode prev = secHalfHead;
        ListNode curr = secHalfHead.next;
        prev.next = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //compare two halves
        secHalfHead = prev;
        ListNode firstHalfHead = head;
        // the first half is always bigger or equal in size to the second half, so iterate until second half is finished.
        while(secHalfHead !=null){
            if(firstHalfHead.val != secHalfHead.val){
                return false;
            }else{
                firstHalfHead = firstHalfHead.next;
                secHalfHead = secHalfHead.next;
            }
        }
        return true;
    }

    public int findLength(ListNode l) {
        int length = 0;
        while (l != null) {
            length++;
            l = l.next;
        }
        return length;
    }

    public ListNode reverseLinkedList(ListNode l) {
        if (l == null || l.next == null)
            return l;

        ListNode prev = l;
        ListNode curr = l.next;
        prev.next = null;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
