
public class Stacks {
    public static void main(String[] args) {
        /*
        SetofStacks myset = new SetofStacks(1);
        myset.push("hello");
        myset.push("world");
        myset.push("boo");
        myset.push("foo");
        for (int i = 0; i < 5; i++) {
            System.out.println(myset.pop());
        }
        */
        /*
        MyQueue<String> queue = new MyQueue<>();
        queue.add("hello");
        queue.add("world");
        queue.add("boo");
        queue.add("foo");
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.peek());
            queue.remove();
        }
        */
        SortedStack stack = new SortedStack();
        stack.push(10);
        stack.push(1);
        stack.push(8);
        stack.push(9);
        stack.push(20);
        for (int i = 0; i < 6; i++) {
            System.out.println(stack.pop());

        }

    }
}
