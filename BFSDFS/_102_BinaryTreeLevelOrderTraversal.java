package BFSDFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

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

            list.add(subList);
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
