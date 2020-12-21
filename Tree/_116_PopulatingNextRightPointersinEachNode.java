package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class _116_PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        // Solution 1: BFS
//        if (root == null) return root;
//
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//
//            for (int i = 0; i < size; i++) {
//                Node curr = queue.poll();
//                Node next = null;
//
//                if (i < size - 1) {
//                    next = queue.peek();
//                    curr.next = next;
//                }
//                if (curr.left != null) {
//                    queue.add(curr.left);
//                }
//                if (curr.right != null) {
//                    queue.add(curr.right);
//                }
//            }
//        }
//
//        return root;

        //Solution 2: Time: O(n); Space: O(1);
        if (root == null) {
            return root;
        }

        Node levelStart = root;
        while (levelStart != null) {
            Node curr = levelStart;

            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right;
                }
                if (curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }

            levelStart = levelStart.left;
        }

        return root;

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
    }

}
