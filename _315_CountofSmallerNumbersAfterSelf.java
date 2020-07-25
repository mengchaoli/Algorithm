import java.util.*;

public class _315_CountofSmallerNumbersAfterSelf {
    // Solution1: BST
//    class Node {
//        int count = 0, leftCount = 0;
//        int value;
//        Node left, right;
//        public Node(int value) {
//            this.value = value;
//        }
//    }
//
//    public List<Integer> countSmaller(int[] nums) {
//        Integer[] res = new Integer[nums.length];
//        if (nums.length == 0) return Arrays.asList(res);
//
//        Node root = new Node(nums[nums.length - 1]);
//
//        for (int i = nums.length - 1; i >= 0; i--) {
//            res[i] = helper(root, nums[i]);
//        }
//
//        return Arrays.asList(res);
//    }
//
//    private int helper(Node node, int val) {
//        int sum = 0;
//        while (node.value != val) {
//            if (node.value > val) {
//                node.leftCount++;
//                if (node.left == null) node.left = new Node(val);
//                node = node.left;
//            } else {
//                sum += node.count + node.leftCount;
//                if (node.right == null) node.right = new Node(val);
//                node = node.right;
//            }
//        }
//
//        node.count++;
//        return sum + node.leftCount;
//    }

    //Solution2: FenwickTree /BIT

    class FenwickTree {
        private int[] sums;

        public FenwickTree(int size) {
            sums = new int[size + 1];
        }

        public void update(int i, int delta) {
            while (i < sums.length) {
                sums[i] += delta;
                int lowbit = i & (-i);
                i += lowbit;
            }
        }

        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += sums[i];
                int lowbit = i & (-i);
                i -= lowbit;
            }
            return sum;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int rank = 0;
        Map<Integer, Integer> ranks = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            if (i == 0 || sorted[i - 1] != sorted[i]) {
                ranks.put(sorted[i], ++rank);
            }
        }

        FenwickTree tree = new FenwickTree(ranks.size());
        List<Integer> res = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int sum = tree.query(i);
            tree.update(ranks.get(nums[i]), 1);
            res.add(tree.query(ranks.get(nums[i]) - 1));
        }

        Collections.reverse(res);
        return res;
    }
}
