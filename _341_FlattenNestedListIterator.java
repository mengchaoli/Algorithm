import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> flattedList = new ArrayList<>();
    int idx = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        init(nestedList);
    }

    private void init(List<NestedInteger> nestedList) {
        for (NestedInteger nti : nestedList) {
            if (!nti.isInteger()) {
                init(nti.getList());
            } else {
                flattedList.add(nti.getInteger());
            }
        }
    }

    @Override
    public Integer next() {
        return flattedList.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx == flattedList.size() ? false : true;
    }
}