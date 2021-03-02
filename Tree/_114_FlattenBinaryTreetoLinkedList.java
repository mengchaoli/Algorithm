package Tree;

public class _114_FlattenBinaryTreetoLinkedList {

//    TreeNode prev = null;
//    public void flatten(TreeNode root) {
//        if (root == null)
//            return;
//
//        flatten(root.left);
//        flatten(root.right);
//
//        root.right = prev;
//        root.left = null;
//        prev = root;
//    }

    // Solution 2: We want to record the leftTail. How? Store it in our return value
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftTail = helper(root.left);
        TreeNode rightTail = helper(root.right);

        // there are three parts: one is root(R), one is left flattened child(A), one is right flattened child(B).
        // what we need to do is to insert A between R and B; first leftTail.right = root.right, then root.right = root.left, and dont forget root.left = null
        // and we only do those when leftTail is not null; if leftTail is null, so we dont need to do anything, it is flattened alreay;
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        // and if rightTail is not null, we should first return rightTail. because we care about the last node, and after insertion(line34~38), the last node
        // should be rightTail, because leftTail is inserted between R and B
        if (rightTail != null) {
            return rightTail;
        }

        // if rightTail is null, we check if leftTail is null, if leftTail is not null, we should return leftTail because it was moved to right and will act as the last node
        if (leftTail != null) {
            return leftTail;
        }

        // if both leftTail is null and rightTail is null, means this is a leaf node, we just need to return this node
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }
}
