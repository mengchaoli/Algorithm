package Tree;

import javafx.util.Pair;

import java.util.*;

public class _987_VerticalOrderTraversalofaBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Pair<TreeNode, Pair<Integer, Integer>>> list = new LinkedList<>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, new Pair<>(0, 0)));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Pair<Integer, Integer>> current = queue.poll();
                list.add(current);

                if (current.getKey().left != null) {
                    queue.add(new Pair<>(current.getKey().left, new Pair<>(current.getValue().getKey() - 1, current.getValue().getValue() + 1)));
                }
                if (current.getKey().right != null) {
                    queue.add(new Pair<>(current.getKey().right, new Pair<>(current.getValue().getKey() + 1, current.getValue().getValue() + 1)));
                }
            }
        }

        Collections.sort(list, (o1, o2) -> (o1.getValue().getKey() - o2.getValue().getKey()));

        int i = 0;
        List<List<Integer>> res = new LinkedList<>();
        while (i < list.size()) {
            int currentX = list.get(i).getValue().getKey();

            List<Pair<TreeNode, Pair<Integer, Integer>>> subList = new LinkedList<>();
            while (i < list.size() && list.get(i).getValue().getKey() == currentX) {
                subList.add(list.get(i));
                i++;
            }

            Collections.sort(subList, (o1, o2) -> {
                if (o1.getValue().getValue() != o2.getValue().getValue()) {
                    return o1.getValue().getValue() - o2.getValue().getValue();
                } else {
                    return o1.getKey().val - o2.getKey().val;
                }
            });

            List<Integer> subAns = new LinkedList<>();
            for (int j = 0; j < subList.size(); j++) {
                subAns.add(subList.get(j).getKey().val);
            }

            res.add(subAns);
        }

        return res;
    }

    public class TreeNode {
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
