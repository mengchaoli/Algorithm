package Tree;

public class _270_ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        int val, res = root.val;

        while (root != null) {
            val = root.val;
            res = Math.abs(val - target) < Math.abs(res - target) ? val : res;
            root = target < val ? root.left : root.right;
        }
        return res;
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
