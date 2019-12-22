import java.util.LinkedList;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

//BFS
public class _364_NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Deque<NestedInteger> deque = new LinkedList<>();
        for (NestedInteger ni : nestedList) {
            deque.add(ni);
        }

        int prevSum = 0, totalSum = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                NestedInteger current = deque.pollFirst();
                if (current.isInteger()) {
                    prevSum += current.getInteger();
                } else {
                    for (NestedInteger ni : current.getList()) {
                        deque.offerLast(ni);
                    }
                }
            }
            totalSum += prevSum;
        }
        return totalSum;
    }
}
