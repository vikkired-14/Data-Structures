public class ReorderList {

//    Input: head = [1,2,3,4]
//    Output: [1,4,2,3]

//    Input: head = [1,2,3,4,5]
//    Output: [1,5,2,4,3]
//Middle of the Linked List.
//
//    Reverse Linked List.
//
//    Merge Two Sorted Lists.

    public static void reorderList(ListNode head) {
        if(head==null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){ //Middle of the Linked List.
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while (slow != null) { //    Reverse Linked List.
            fast = slow.next;
            slow.next = prev;
            prev = slow;
            slow = fast;
        }
        ListNode first = head, second = prev;
        while(second.next!=null){ //    Merge Two Sorted Lists.  1->2->3    5->4
            ListNode temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
         while(head!=null){
             System.out.println(head.val + "->");
             head = head.next;
         }
    }

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        reorderList(node);
    }
}
