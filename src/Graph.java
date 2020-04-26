import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus- on 26.04.2020.
 */
public class Graph {
    class Node{
        String data;
        LinkedList<Node> neigbours;

        public Node(String data, List<Node> neigbours){
            this.data = data;
            this.neigbours = new LinkedList<>(neigbours);
        }
        public Node(String data){
            this.data = data;
            this.neigbours = new LinkedList<>();
        }
    }
    public Graph(){}
}
