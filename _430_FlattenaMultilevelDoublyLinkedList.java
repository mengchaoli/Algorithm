/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
public class _430_FlattenaMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        if (head == null)
            return null;

        Node p = head;
        while (p != null) {
            if (p.child == null) {
                p = p.next;
                continue;
            }

            Node temp = p.child;
            while (temp.next != null) {
                temp = temp.next;
            }
            // Connect tail with p.next, if it is not null
            temp.next = p.next;
            if (p.next != null) p.next.prev = temp;
            // Connect p with p.child, and remove p.child
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}
