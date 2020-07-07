import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class _1172_DinnerPlateStacks {

    int capacity;
    List<Stack<Integer>> stacks;
    TreeSet<Integer> openStacks;

    public _1172_DinnerPlateStacks(int capacity) {
        this.stacks = new ArrayList<>();
        this.openStacks = new TreeSet<>();
        this.capacity = capacity;
    }

    public void push(int val) {
        if (openStacks.size() == 0) {
            stacks.add(new Stack<>());
            openStacks.add(stacks.size() - 1);
        }

        stacks.get(openStacks.first()).push(val);
        if (stacks.get(openStacks.first()).size() == capacity) {
            openStacks.remove(openStacks.first());
        }
    }

    public int pop() {
        return myPop(stacks.size() - 1);
    }

    public int popAtStack(int index) {
        return myPop(index);
    }

    private int myPop(int i) {
        if (i < 0 || i >= stacks.size() || stacks.get(i).isEmpty()) {
            return -1;
        }

        int res = stacks.get(i).pop();
        openStacks.add(i);

        while (stacks.size() > 0 && stacks.get(stacks.size() - 1).isEmpty()) {
            int index = stacks.size() - 1;
            stacks.remove(index);
            openStacks.remove(index);
        }

        return res;
    }
}
