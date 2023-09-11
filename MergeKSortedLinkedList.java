import java.util.*;

public class MergeKSortedLinkedList {

    public static ListNode getSortedLinkedList(ListNode[] lists) {
        PriorityQueue<ListNode> qq = minHeap(lists);
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (!qq.isEmpty()) {
            ListNode node = qq.poll();
            tail.next = node;
            node = node.next;
            tail = tail.next;

            if (node != null)
                qq.add(node);
        }

        return head.next;
    }

    private static PriorityQueue<ListNode> minHeap(ListNode[] lists) {

        PriorityQueue<ListNode> qq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null)
                qq.add(node);
        }
        return qq;
    }


    private static ListNode[] getLinkedListArray(int[][] arr) {
        List<ListNode> list = new ArrayList<>();
        for (int[] A : arr) {
            ListNode node = new ListNode(0);
            ListNode temp = node;
            for (int i : A) {
                temp.next = new ListNode(i);
                temp = temp.next;
            }
            list.add(node.next);
        }
        return list.toArray(new ListNode[0]);
    }

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}};

        ListNode[] listNode = getLinkedListArray(arr);
        ListNode head = getSortedLinkedList(listNode);

        while (head != null) {
            System.out.println(head.val + "->");
            head = head.next;
        }


    }
}
