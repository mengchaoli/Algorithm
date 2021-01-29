package Tree;

import java.util.Stack;

public class _1209_RemoveAllAdjacentDuplicatesinStringII {
    public String removeDuplicates(String s, int k) {
//        Stack<Character> stack = new Stack<>();
//        Stack<Integer> count = new Stack<>();
//
//        for (char c : s.toCharArray()) {
//            if (stack.isEmpty() || c != stack.peek()) {
//                stack.push(c);
//                count.push(1);
//            } else {
//                if (count.peek() == k - 1) {
//                    for (int i = 0; i < k - 1; i++) {
//                        stack.pop();
//                    }
//                    count.pop();
//                } else {
//                    stack.push(c);
//                    count.push(count.pop() + 1);
//                }
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()) {
//            sb.insert(0, stack.pop());
//        }
//
//        return sb.toString();

        // Solution 2:
        int[] count = new int[s.length()];
        int i = 0;
        char[] res = s.toCharArray();

        for (int j = 0; j < s.length(); j++, i++) {
            res[i] = res[j];
            count[i] = i > 0 && res[i] == res[i - 1] ? count[i - 1] + 1 : 1;
            if (count[i] == k) {
                i -= k;
            }
        }

        return new String(res, 0, i);
    }

}
