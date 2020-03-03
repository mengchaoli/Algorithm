package Tree;

public class _114_FlattenBinaryTreetoLinkedList {

    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.left);
        flatten(root.right);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
