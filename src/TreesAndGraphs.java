import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreesAndGraphs {

    public static BinaryNode createBST (int[] sortedArr){
        return createBST ( sortedArr, 0, sortedArr.length -1);
    }
    public static BinaryNode createBST (int[] sortedArr, int subStartIndex, int subEndIndex){

        if(subStartIndex > subEndIndex){return null;}
        int currentIndex = (subStartIndex + subEndIndex)/2;
        BinaryNode n = new BinaryNode(""+sortedArr[currentIndex]);
        n.left = createBST( sortedArr,  subStartIndex,  currentIndex-1);
        n.right = createBST( sortedArr,  currentIndex+1,  subEndIndex);
        return n;

    }

    public static ArrayList<LinkedList<BinaryNode>> listOfDepths(BinaryNode root){
        ArrayList<LinkedList<BinaryNode>> depths = new ArrayList<>();
        int level = 0;
        addToLevel(depths,root,0);
        return depths;
    }

    public static void addToLevel(ArrayList<LinkedList<BinaryNode>> depths, BinaryNode n, int level){
        if(depths.size()-1 < level){
            depths.add(level, new LinkedList<BinaryNode>());
        }
        depths.get(level).add(n);
        if(n.left != null){addToLevel(depths,n.left,level+1);}
        if(n.right != null){addToLevel(depths,n.right,level+1);}
    }

    public static void inOrder(BinaryNode root){
        if(root.left != null){inOrder(root.left);}
        System.out.print(root.data + " ");
        if(root.right != null){inOrder(root.right);}
    }
    public static void preOrder(BinaryNode root){
        System.out.print(root.data + " ");
        if(root.left != null){preOrder(root.left);}
        if(root.right != null){preOrder(root.right);}
    }

    public static void main(String[] args) {
        /*int[] sorted = {1, 2, 3, 4 ,9, 11, 25, 29};
        preOrder(createBST(sorted));
        ArrayList<LinkedList<BinaryNode>> list = listOfDepths(createBST(sorted));
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.get(i).size() ; j++) {
                System.out.print("-" +list.get(i).get(j).data);
            }
            System.out.println();
        }*/
    }
}
