package Tree;

public class _99_RecoverBinarySearchTree {
    TreeNode firstEle = null;
    TreeNode secondEle = null;
    TreeNode prevEle = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        if (root == null) return;

        traverse(root);

        int temp = firstEle.val;
        firstEle.val = secondEle.val;
        secondEle.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);

        if (firstEle == null && prevEle.val > root.val) {
            firstEle = prevEle;
        }

        if (firstEle != null && prevEle.val > root.val) {
            secondEle = root;
        }

        prevEle = root;

        traverse(root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
