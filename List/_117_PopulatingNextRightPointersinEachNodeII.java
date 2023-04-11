package List;

public class _117_PopulatingNextRightPointersinEachNodeII {
    public Node connect(Node root) {
        Node res = root;
        while (root != null) {
            Node currChild = new Node(0);
            Node tempChild = currChild;

            while (root != null) {
                if (root.left != null) {
                    currChild.next = root.next;
                    currChild = currChild.next;
                }
                if (root.right != null) {
                    currChild.next = root.right;
                    currChild = currChild.next;
                }
                root = root.next;
            }
            root = tempChild.next;
        }

        return res;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
