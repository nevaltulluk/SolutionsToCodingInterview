import java.sql.Array;
import java.util.Arrays;

/**
 * Created by asus- on 17.04.2020.
 */
public class ArraysAndStrings {
    // null string as input assumed true
    // white space considered as a character
    public static boolean isUnique(String input){
        int[] characters = new int[127];
        for (int i = 0; i < input.length(); i++) {
            if(characters[input.charAt(i)] == 0){
                characters[input.charAt(i)] = 1;
            }
            else{return false;}
        }
        return true;
    }
    public static boolean checkPermutation(String S1, String S2){
        int[] A1 = new int[128];
        int[] A2 = new int[128];

        for (int i = 0 ; i < S1.length() ; i++) {
            A1[S1.charAt(i)] += 1;
        }
        for (int i = 0 ; i < S2.length() ; i++) {
            A2[S2.charAt(i)] += 1;
        }
        if(Arrays.equals(A1,A2)){
            return true;
        }
        else {return false;}
    }
    public static String URLify(String input, int len){
        char[] arr = input.toCharArray();
        int endspace = input.length() - len;
        int urlpointer = input.length() - 1;
        int currpointer = input.length() - 1 - endspace;
        while (currpointer > -1){
            if (arr[currpointer] != ' ') {
                arr[urlpointer] = arr[currpointer];
                currpointer--;urlpointer--;
            }
            else{
                arr[urlpointer] = '0';
                arr[urlpointer-1] = '2';
                arr[urlpointer-2] = '%';
                currpointer--;
                urlpointer-=3;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        //System.out.println(isUnique("hello world"));
        //System.out.println(checkPermutation("h ell o ", "el l ho "));
        //System.out.println(URLify("h e l lo      ", 8));


    }
}
