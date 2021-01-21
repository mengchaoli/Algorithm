package Tree;

import javafx.util.Pair;

import java.util.*;

public class _987_VerticalOrderTraversalofaBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Pair<TreeNode, Pair<Integer, Integer>>>> hashMap = new HashMap<>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> workingQueue = new LinkedList<>();
        int min = 0, max = 0;
        workingQueue.offer(new Pair<TreeNode, Pair<Integer, Integer>>(root, new Pair<Integer, Integer>(0, 0)));

        while (!workingQueue.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> current = workingQueue.poll();

            min = Math.min(min, current.getValue().getKey());
            max = Math.max(max, current.getValue().getKey());

            if (!hashMap.containsKey(current.getValue().getKey()))
                hashMap.put(current.getValue().getKey(), new ArrayList<>());
            hashMap.get(current.getValue().getKey()).add(current);

            if (current.getKey().left != null) {
                workingQueue.offer(new Pair<TreeNode, Pair<Integer, Integer>>(current.getKey().left, new Pair<Integer, Integer>(current.getValue().getKey() - 1, current.getValue().getValue() + 1)));
            }


            if (current.getKey().right != null) {
                workingQueue.offer(new Pair<TreeNode, Pair<Integer, Integer>>(current.getKey().right, new Pair<Integer, Integer>(current.getValue().getKey() + 1, current.getValue().getValue() + 1)));
            }
        }

        for (int i = min; i <= max; i++) {
            Collections.sort(hashMap.get(i), new Comparator<Pair<TreeNode, Pair<Integer, Integer>>>(){
                public int compare(Pair<TreeNode, Pair<Integer, Integer>> left, Pair<TreeNode, Pair<Integer, Integer>> right) {
                    if (left.getValue().getValue() == right.getValue().getValue())
                        return left.getKey().val - right.getKey().val;
                    return 0;
                }
            });

            List<Integer> nodeVals = new ArrayList<>();

            for (int j = 0; j < hashMap.get(i).size(); j++) {
                nodeVals.add(hashMap.get(i).get(j).getKey().val);
            }

            res.add(nodeVals);
        }
        return res;
    }
}
