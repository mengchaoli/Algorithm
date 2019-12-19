import java.util.Stack;

public class _1130_MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int ans = 0;

        for (int a : arr) {
            while (stack.peek() <= a) {
                int drop = stack.pop();
                ans += drop * Math.min(stack.peek(), a);
            }

            stack.push(a);
        }

        while (stack.size() > 2) {
            ans += stack.peek() * stack.pop();
        }

        return ans;
    }
}

// Explanation Link: https://www.youtube.com/watch?v=xcYkzSrgOmY