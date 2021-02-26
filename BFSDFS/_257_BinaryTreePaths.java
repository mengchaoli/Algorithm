package BFSDFS;

import java.util.LinkedList;
import java.util.List;

public class _257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        helper(root, "", res);
        return res;
    }

    private void helper(TreeNode root, String s, List<String> res) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            res.add(s + root.val);
        }
        helper(root.left, s + "->", res);
        helper(root.right, s + "->", res);
    }
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
