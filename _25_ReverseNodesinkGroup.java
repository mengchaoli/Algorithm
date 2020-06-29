public class _25_ReverseNodesinkGroup {
    //There are two solutions. One is using recursion, one is using iteration.
    //And for recursion, these "reverse linkedlist or listnode in K group" problems are usually include two steps
    //Here is a summary about these two steps for recursion.
//    public ListNode reverseKGroup(ListNode head, int k) {
//        //1. test weather we have more then k node left, if less then k node left we just return head
//        int count = 0;
//        ListNode node = head;
//
//        while (count < k) {
//            if (node == null) return head;
//            count++;
//            node = node.next;
//        }
//
//        // 2.reverse k node at current level
//        ListNode pre = reverseKGroup(node, k);
//
//        while (count > 0) {
//            ListNode next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//            count--;
//        }
//
//        return pre;
//    }

    //Solution2: Iteration
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode begin = dummy;
        int count = 0;

        while (head != null) {
            count++;

            if (count % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode next;
        ListNode pre = begin;
        ListNode first = curr;

        while (curr != end) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        first.next = end;
        begin.next = pre;

        return first;
    }


    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
