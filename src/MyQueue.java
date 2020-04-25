import java.util.Stack;

//queue with 2 stacks
public class MyQueue<T> {
    private Stack<T> headFirst;
    private Stack<T> tailFirst;

    public MyQueue() {
        headFirst = new Stack<T>();
        tailFirst = new Stack<T>();
    }
    public void add(T element){
        if(!headFirst.isEmpty()){
            while(!headFirst.isEmpty()){
                tailFirst.push(headFirst.pop());
            }
        }
        tailFirst.push(element);
    }
    public T peek() {
        if (!tailFirst.isEmpty()) {
            while (!tailFirst.isEmpty()) {
                headFirst.push(tailFirst.pop());
            }
        }
        if(headFirst.isEmpty()){
            return null;
        }
        T element = headFirst.pop();
        headFirst.push(element);
        return element;
    }
    public void remove() {
        if (!tailFirst.isEmpty()) {
            while (!tailFirst.isEmpty()) {
                headFirst.push(tailFirst.pop());
            }

        }
        if(!headFirst.isEmpty()){
            T element = headFirst.pop();
        }
    }
}