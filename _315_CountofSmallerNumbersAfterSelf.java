import java.util.Arrays;
import java.util.List;

public class _315_CountofSmallerNumbersAfterSelf {

    class Node {
        int count = 0, leftCount = 0;
        int value;
        Node left, right;
        public Node(int value) {
            this.value = value;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        if (nums.length == 0) return Arrays.asList(res);

        Node root = new Node(nums[nums.length - 1]);

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = helper(root, nums[i]);
        }

        return Arrays.asList(res);
    }

    private int helper(Node node, int val) {
        int sum = 0;
        while (node.value != val) {
            if (node.value > val) {
                node.leftCount++;
                if (node.left == null) node.left = new Node(val);
                node = node.left;
            } else {
                sum += node.count + node.leftCount;
                if (node.right == null) node.right = new Node(val);
                node = node.right;
            }
        }

        node.count++;
        return sum + node.leftCount;
    }
}
