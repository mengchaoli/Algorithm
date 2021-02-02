import java.util.Deque;
import java.util.LinkedList;

// Time: O(N)
public class _150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String s : tokens) {
            if (s.equals("/") || s.equals("*") || s.equals("+") || s.equals("-")) {
                int right = deque.pollFirst();
                int left = deque.pollFirst();
                if (s.equals("/")) {
                    deque.addFirst(left / right);
                } else if (s.equals("*")) {
                    deque.addFirst(left * right);
                } else if (s.equals("+")) {
                    deque.addFirst(left + right);
                } else if (s.equals("-")) {
                    deque.addFirst(left - right);
                }
            } else {
                deque.addFirst(Integer.valueOf(s));
            }
        }

        return deque.poll();
    }
}
