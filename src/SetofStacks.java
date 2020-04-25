import java.util.ArrayList;
import java.util.Stack;

public class SetofStacks{

    private int currentStack;
    private int capacity;
    private ArrayList<Stack<String>> stacks = new ArrayList<>();

    public SetofStacks(int capacity){
        this.capacity = capacity;
        this.currentStack = 0;
        stacks.add(new Stack<String>());
    }
    public int getCapacity(){return this.capacity;}
    public void push(String element){
        if (!(stacks.get(currentStack).size() <= capacity)){
            currentStack++;
            stacks.add(new Stack<String>());
        }
        stacks.get(currentStack).push(element);
    }
    public String pop(){
        if (stacks.get(currentStack).isEmpty()){
            stacks.remove(currentStack);
            currentStack--;
        }
        if(currentStack == -1){
            System.out.println("Set of Stacks is empty");
            return "";
        }
        return stacks.get(currentStack).pop();
    }
    public String popAt(int stackIndex){
        if (stacks.get(currentStack).isEmpty()){
            System.out.println("Stack is Empty");
        }
        return stacks.get(stackIndex).pop();
    }
}