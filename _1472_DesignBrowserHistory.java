import java.util.Stack;

public class _1472_DesignBrowserHistory {

    Stack<String> inStack = new Stack<>();
    Stack<String> outStack = new Stack<>();

    public _1472_DesignBrowserHistory(String homepage) {
        inStack.push(homepage);
    }

    public void visit(String url) {
        inStack.push(url);
        outStack.clear();
    }

    public String back(int steps) {
        int min = Math.min(steps, inStack.size() - 1);
        for (int i = 0; i < min; i++) {
            outStack.push(inStack.pop());
        }

        return inStack.peek();
    }
    public String forward(int steps) {
        int min = Math.min(steps, outStack.size());
        for (int i = 0; i < min; i++) {
            inStack.push(outStack.pop());
        }

        return inStack.peek();
    }

}
