package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return res;

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (i == 0){
                    res.add(curr.val);
                }
                if (curr.right != null)   //here we put the right node first coz we are looking from the right side. And if so, we can just get the first element during each level, that is the right most element in each level
                    queue.add(curr.right);
                if (curr.left != null)
                    queue.add(curr.left);
            }
        }
        return res;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
