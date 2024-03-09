package google.arraysAndStrings;

/*
 * Problem URL : https://leetcode.com/problems/merge-k-sorted-lists
 * */
public class MergeKSortedListProblem {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};
        ListNode.printLinkedList(new MergeKSortedListProblem().mergeKLists(lists));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        // utility method to print LL
        public static void printLinkedList(ListNode head) {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
        }
    }

    // method to merge lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode dummy = temp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }

        temp.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }

    /*
     * Time Complexity : O(nlogK) [k is number of LL ]
     * Space Complexity : O(1)
     * */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2)
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);

            interval *= 2;
        }

        return lists[0];
    }

    /*
     public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = createMinHeap(lists);
        ListNode head = new ListNode(-1);
         ListNode tail = head ;
         while(!minHeap.isEmpty()){
             ListNode node = minHeap.poll();
                 tail.next = node;
                 node = node.next;
                 tail = tail.next;
                 if(node!=null){
                     minHeap.add(node);
             }
         }
         return head.next;
    }

    public  PriorityQueue<ListNode> createMinHeap(ListNode[] lists){

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val-l2.val;
            }
        });

        for(ListNode l : lists){
            if(l!=null)
            pq.add(l);
        }
     return pq;
    }
     */
}
