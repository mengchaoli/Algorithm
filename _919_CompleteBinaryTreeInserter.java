/*
* A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:

CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
CBTInserter.get_root() will return the head node of the tree.


Example 1:

Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
Output: [null,1,[1,2]]
Example 2:

Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
Output: [null,3,4,[1,2,3,4,5,6,7,8]]


Note:

The initial given tree is complete and contains between 1 and 1000 nodes.
CBTInserter.insert is called at most 10000 times per test case.
Every value of a given or inserted node is between 0 and 5000.
* */

//Solution:
//Store tree nodes to a list self.tree in bfs order.
//Node tree[i] has left child tree[2 * i + 1] and tree[2 * i + 2]
//
//So when insert the Nth node (0-indexed), we push it into the list.
//we can find its parent tree[(N - 1) / 2] directly.

//KEEP IN MIND!!! When meets complete binary tree problem, please think about using Array.
//Because we can find the node and its parents or the node and its sons easily via the index!

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;

public class _919_CompleteBinaryTreeInserter {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<TreeNode> tree;

    public _919_CompleteBinaryTreeInserter(TreeNode root) {
        tree = new ArrayList<>();
        tree.add(root);
        for (int i = 0; i < tree.size(); i++) {
            if (tree.get(i).left != null) tree.add(tree.get(i).left);
            if (tree.get(i).right != null) tree.add(tree.get(i).right);
        }
    }

    public int insert(int v) {
        int N = tree.size();
        TreeNode node = new TreeNode(v);
        tree.add(node);

        if (N % 2 == 1) {
            tree.get((N - 1) / 2).right = node;
        } else {
            tree.get((N - 1) / 2).left = node;
        }

        return tree.get((N - 1) / 2).val;
    }

    public TreeNode get_root() {
        return tree.get(0);
    }

}
