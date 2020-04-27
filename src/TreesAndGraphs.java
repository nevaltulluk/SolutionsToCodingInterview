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
    public static void postOrder(BinaryNode root){

        if(root.left != null){preOrder(root.left);}
        if(root.right != null){preOrder(root.right);}
        System.out.print(root.data + " ");
    }

    public static boolean isBalanced(BinaryNode n){
        boolean flag = true;
        if(n == null){flag = true; return flag;}
        boolean leftbalance = isBalanced(n.left);
        boolean rightbalance = isBalanced(n.right);
        int diff = Math.abs(heights(n.right)-heights(n.left));
        if(diff > 1){flag = false;}
        return leftbalance && rightbalance && flag;

    }

    public static int heights(BinaryNode n){
        if (n == null) {return -1;}
        int leftsub = -1;
        int rightsub = -1;
        if(n.left != null){
            leftsub = heights(n.left);
        }
        if(n.right != null){
            rightsub = heights(n.right);
        }
        return Math.max(rightsub,leftsub)+1;
    }
    public static boolean validateBST(BinaryNode root){
        ArrayList<Integer> inOrder = new ArrayList<>();
        addToList(inOrder,root);
        for(int i = 0 ; i < inOrder.size()-1; i++){
            if(inOrder.get(i) > inOrder.get(i+1)){
                return false;
            }
        }
        return true;

    }

    public static void addToList(ArrayList<Integer> list, BinaryNode n){
        if(n.left!=null) addToList(list,n.left);
        list.add(Integer.parseInt(n.data));
        if(n.right!=null) addToList(list,n.right);
    }

    public static BinaryNode next (BinaryNode n){
        ArrayList<BinaryNode> list = new ArrayList<>();
        inOrder(n, list);
        for(int i = 0; i < list.size(); i++){
            if(n == list.get(i) && i+1 < list.size()) return (list.get(i+1));
        }
        return null;

    }
    public static void inOrder (BinaryNode n, ArrayList<BinaryNode> list){
        if(n.left != null) inOrder(n.left,list);
        list.add(n);
        if(n.right != null) inOrder(n.right,list);

    }

    public static void main(String[] args) {
        int[] sorted = {1, 2, 3, 4 ,9, 11, 25, 29};

        BinaryNode leaf1 = new BinaryNode("1");
        BinaryNode parent1 = new BinaryNode("2");
        BinaryNode parent2 = new BinaryNode("3");
        BinaryNode root = new BinaryNode("4");
        root.left = parent1;
        parent1.left = parent2;
        root.right = leaf1;


        System.out.println(createBST(sorted).right.data + " -- " + next(createBST(sorted).right).data);
        /*
        preOrder(createBST(sorted));
        ArrayList<LinkedList<BinaryNode>> list = listOfDepths(createBST(sorted));
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.get(i).size() ; j++) {
                System.out.print("-" +list.get(i).get(j).data);
            }
            System.out.println();
        }
        */
    }
}
