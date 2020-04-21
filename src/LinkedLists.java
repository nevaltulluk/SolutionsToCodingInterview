import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;


public class LinkedLists {
    public static void removeDups(LinkedList<Integer> input){
        HashMap<Integer, Integer> map = new HashMap<>();
        ListIterator<Integer> iter = input.listIterator(0);
        while(iter.hasNext()){
            int temp = iter.next();
            if(map.containsKey(temp)){
                iter.remove();
            }
            else{
                map.put(temp,1);
            }
        }
    }
    public static String kthToLast(LinkedList<String> list, int k){
        ListIterator<String> bigIter = list.listIterator(k);
        ListIterator<String> smallIter= list.listIterator(0);
        while(bigIter.hasNext()){
            bigIter.next();
            smallIter.next();
        }
        return smallIter.next();
    }
    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {intList.push(i % 5);}
        LinkedList<String> strList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {strList.push("a"+i);}
        //System.out.println(intList);
        //removeDups(list);
        //System.out.println(kthToLast(strList,4));
    }
}
