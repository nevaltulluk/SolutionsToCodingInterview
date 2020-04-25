import javafx.util.Pair;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
    public static void partition(LinkedList<Integer> list, int value){
        LinkedList<Integer> bigger = new LinkedList<>();

        ListIterator<Integer> iter = list.listIterator();
        while(iter.hasNext()){
            int current = iter.next();
            if(current >= value){
                iter.remove();
                bigger.add(current);
            }
        }
        list.addAll(bigger);
    }
    public static LinkedList<Integer> sumLists(LinkedList<Integer> l1, LinkedList<Integer> l2){
        int carry = 0;
        LinkedList<Integer> res = new LinkedList<>();
        while(!l1.isEmpty() || !l2.isEmpty()){
            int currentl1 = 0;
            int currentl2 = 0;
            if(!l1.isEmpty()){
                currentl1 = l1.pop();
            }
            if(!l2.isEmpty()){
                currentl2 = l2.pop();
            }

            res.add((currentl1 + currentl2 + carry) % 10);
            carry = (currentl1 + currentl2)/10;

        }
        return res;
    }
    public static List<String> fizzBuzz(int n) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 1 ; i < n+1 ; i++){
            String res = "";
            if(i%3 == 0){
                res += "Fizz";
            }
            if(i%5 == 0){
                res += "Buzz";
            }
            if(i%3 != 0 && i%5 != 5){
                res = ""+i;
            }
            list.add(res);
        }
        return list;
    }

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(5,6);
        map.put(7,5);
        //System.out.println(map.get(5));
        LinkedList<Integer> intList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {intList.push(i);}
        LinkedList<String> strList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {strList.push("a"+i);}
        LinkedList<Integer> smallIntList = new LinkedList<>();
        LinkedList<Integer> smallIntList2 = new LinkedList<>();
        smallIntList.add(6);smallIntList.push(1);smallIntList.push(7);
        smallIntList2.add(2);smallIntList2.push(9);smallIntList2.push(5);
        System.out.println(fizzBuzz(15));
        //System.out.println(intList);
        //removeDups(list);
        //System.out.println(kthToLast(strList,4));
        //System.out.println(intList);
        //partition(intList,3);
        //System.out.println(intList);
        // System.out.println(sumLists(smallIntList,smallIntList2));
    }
}
