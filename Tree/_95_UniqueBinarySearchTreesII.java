package Tree;

import java.util.LinkedList;
import java.util.List;

public class _95_UniqueBinarySearchTreesII {



    public List<TreeNode> generateTrees(int n) {
//        if (n == 0)
//            return new LinkedList<TreeNode>();  this is necessary when using solution 1
        return helper(1, n);
    }
    //Solution 1
//    private List<TreeNode> helper(int min, int max) {
//        List<TreeNode> res = new LinkedList<>();
//        if (min > max) {
//            res.add(null);  //this is necessary in this method
//            return res;
//        }
//
//        for (int rt = min; rt <= max; rt++) {
//            List<TreeNode> leftList = helper(min, rt - 1);
//            List<TreeNode> rightList = helper(rt + 1, max);
//
//            for (TreeNode leftNode : leftList) {
//                for (TreeNode rightNode : rightList) {
//                    TreeNode root = new TreeNode(rt);
//                    root.left = leftNode;
//                    root.right = rightNode;
//                    res.add(root);
//                }
//            }
//        }
//        return res;
//    }

    //Solution 2
    private List<TreeNode> helper(int min, int max) {
        List<TreeNode> res = new LinkedList<>();
        if (min > max) {
            return res;
        }

        for (int rt = min; rt <= max; rt++) {
            List<TreeNode> leftList = helper(min, rt - 1);
            List<TreeNode> rightList = helper(rt + 1, max);

            if (leftList.size() == 0 && rightList.size() == 0) {
                TreeNode root = new TreeNode(rt);
                res.add(root);
            } else if (leftList.size() == 0) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(rt);
                    root.right = right;
                    res.add(root);
                }
            } else if (rightList.size() == 0) {
                for (TreeNode left : leftList) {
                    TreeNode root = new TreeNode(rt);
                    root.left = left;
                    res.add(root);
                }
            } else {
                for (TreeNode left : leftList) {
                    for (TreeNode right : rightList) {
                        TreeNode root = new TreeNode(rt);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
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
