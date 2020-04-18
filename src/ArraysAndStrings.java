import java.util.Arrays;

public class ArraysAndStrings {
    // null string as input assumed true
    // white space considered as a character
    public static boolean isUnique(String input){
        int[] characters = new int[128];
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
    public static boolean isPallindromePerm(String input){
        input = input.toLowerCase();
        int[] alphabet = new int[128];
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' '){
                alphabet[input.charAt(i)] ++;
                count++;
            }
        }

        int odd = 0;
        int even = 0;

        for (int i = 0; i < 128; i++) {
            if (alphabet[i]>0){
                if (alphabet[i]%2 == 1) odd++;
                else even++;

            }
        }
        System.out.println(odd + " " + even + " " + count);
        if ((count%2 == 1 && odd == 1)||(count%2 == 0&& odd == 0)) return true;
        else return false;
    }
    //case1: the # of characters are the same but 1 character is different -> replace
    //case2: the # of characters differ by 1 and rest of the characters are in the same order -> insert/delete

    public static boolean oneAway(String S1, String S2){
        if (S1.equals(S2)) return true;
        else if(S1.length()-S2.length()>1 || S2.length()-S1.length()>1) return false;
        else if(S1.length() == S2.length()){
            boolean edited = false;
            for (int i= 0 ; i < S1.length(); i++){
                if(S1.charAt(i) != S2.charAt(i) && !edited){
                    edited = true;
                }
                else if(S1.charAt(i) != S2.charAt(i) && edited){
                    return false;
                }
            }
        }
        else if(S1.length()-S2.length() == 1){
            int index = 0;
            for(int i= 0 ; i < S2.length(); i++){
                if(S1.charAt(i+index) != S2.charAt(i) && index == 0){
                    index = 1;
                }
                if(S1.charAt(i+index) != S2.charAt(i) && index == 1){
                    return false;
                }
            }
        }
        else {
            if (S2.length() - S1.length() == 1) {
                int index = 0;
                for (int i = 0; i < S1.length(); i++) {
                    if (S2.charAt(i + index) != S1.charAt(i) && index == 0) {
                        index = 1;
                    }
                    if (S2.charAt(i + index) != S1.charAt(i) && index == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static String compresser (String input) {
        int repeated = 1;
        char current = input.charAt(0);
        StringBuffer  res = new StringBuffer();
        for(int i = 1; i < input.length(); i++){
            if(current == input.charAt(i)){
                repeated ++;
            }
            else{
                if(res.length() < input.length()-2){
                    res.append(current);
                    res.append(repeated);
                    current = input.charAt(i);
                    repeated = 1;
                }
                else{
                    return input;
                }
            }
        }
        res.append(current);
        res.append(repeated);
        if (res.length() > input.length()) return input;
        else return res.toString();
    }

    public static void main(String[] args) {
        //System.out.println(isUnique("hello world"));
        //System.out.println(checkPermutation("h ell o ", "el l ho "));
        //System.out.println(URLify("h e l lo      ", 8));
        //System.out.println(isPallindromePerm("Tact Coa"));
        //System.out.println(oneAway("Tact", " Tasd bt    "));
        //System.out.println(compresser("asdfgh"));
    }
}
