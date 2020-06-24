package BFSDFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107_BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();

        if (root == null) {
            return list;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> subList = new LinkedList<>();

            for (int i = 0; i < count; i++) {
                TreeNode curr = queue.poll();
                subList.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            ((LinkedList<List<Integer>>) list).addFirst(subList);
        }
        return list;
    }



    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
