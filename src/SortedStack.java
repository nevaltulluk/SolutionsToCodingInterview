import java.util.Stack;

public class SortedStack {
    boolean flag = false;
    private Stack<Integer> tempStack;
    private Stack<Integer> sorted;

    public SortedStack() {
        tempStack = new Stack<Integer>();
        sorted = new Stack<Integer>();
    }

    public void push(Integer element) {
        if (sorted.isEmpty()) {
            sorted.push(element);
        } else {
            Integer temp = sorted.pop();
            while (temp < element) {
                tempStack.push(temp);
                if (sorted.isEmpty()) {
                    flag = true;
                    break;
                }
                temp = sorted.pop();
            }
            if (flag) {
                sorted.push(element);
            } else {
                sorted.push(temp);
                sorted.push(element);
            }
            while (!tempStack.isEmpty()) {

                sorted.push(tempStack.pop());
            }
        }
    }

    public Integer pop() {
        if (sorted.isEmpty()) {
            return null;
        }
        return sorted.pop();

    }

}