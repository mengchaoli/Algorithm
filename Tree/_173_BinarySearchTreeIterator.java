package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _173_BinarySearchTreeIterator {
    //My Solution
    Queue<TreeNode> queue;

    public _173_BinarySearchTreeIterator(TreeNode root) {
        queue = new LinkedList<>();
        if (root != null)
            fillQueue(root);
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public int next() {
        return queue.poll().val;
    }

    private void fillQueue(TreeNode root) {
        if (root.left != null)
            fillQueue(root.left);

        queue.add(root);

        if (root.right != null)
            fillQueue(root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //Solution 2
    Stack<TreeNode> stack;
//    public _173_BinarySearchTreeIterator(TreeNode root) {
//        stack = new Stack<>();
//        while (root != null) {
//            stack.add(root);
//            root = root.left;
//        }
//    }
//
//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
//
//    public int next() {
//        TreeNode node = stack.pop();
//
//        TreeNode curr = node.right;
//
//        while (curr != null) {
//            stack.add(curr);
//            curr = curr.left;
//        }
//        return node.val;
//    }

}
