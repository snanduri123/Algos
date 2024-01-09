package AppleLeetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public static void printAllNodes(ListNode head){
        if(head ==null){
            System.out.print("null");
        }
        System.out.println();
        while(head!=null){
            System.out.print(head.val + "--->");
            head=head.next;
        }
    }
}