package Array;

import java.util.Stack;

public class _735_AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);

        for (int i = 1; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
                continue;
            }
            int afterCollision = asteroids[i];
            while (!stack.isEmpty() && stack.peek() > 0 && afterCollision < 0) {
                int topAste = stack.pop();
                if (topAste + asteroids[i] > 0) {
                    afterCollision = topAste;
                } else if (topAste + asteroids[i] < 0) {
                    afterCollision = asteroids[i];
                } else {
                    afterCollision = 0;
                }
            }
            if (afterCollision != 0) {
                stack.push(afterCollision);
            }
        }

        int idx = stack.size();
        int[] res = new int[idx];
        while(idx >= 0) {
            res[--idx] = stack.pop();
        }

        return res;
    }
}
