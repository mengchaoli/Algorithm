package Tree;

public class _979_DistributeCoinsinBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    int step = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return step;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        step += Math.abs(left) + Math.abs(right);
        return root.val + left + right + 1;
    }

}
