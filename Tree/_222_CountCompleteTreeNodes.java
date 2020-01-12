package Tree;

public class _222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null) return 1;

        int nodesAbove = 0;
        int height = 0;
        TreeNode curr = root;
        while (curr.left != null) {
            nodesAbove += (1 << height);
            height++;
            curr = curr.left;
        }

        return nodesAbove + countLastLevel(root, height);
    }

    private int countLastLevel(TreeNode root, int height) {
        if (height == 1) {
            if (root.right != null) return 2;
            else if (root.left != null) return 1;
            else return 0;
        }

        TreeNode midNode = root.left;
        int currHeight = 1;
        while (currHeight < height) {
            midNode = midNode.right;
            currHeight++;
        }

        if (midNode == null) return countLastLevel(root.left, height - 1);
        else return (1 << (height - 1)) + countLastLevel(root.right, height - 1);
    }




    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
