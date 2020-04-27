
public class BitManipulation {
    public static int insertInt (int N, int M, int j, int i){
        return (N | (M << i));
    }
    public static String BinToStr(double t){
        String ret = "";
        double curr = 0.5;
        while(t > 0){
            if(ret.length() > 32) return "ERROR";
            if(t >= curr) {
                ret = ret + "1";
                t -= curr;
            }
            else ret = ret + "0";
            curr = curr/2;
        }
        return ret;
    }
    public static int flipToWin(int N){
        int max = 0;
        int count1 = 0;
        int count2 = 0;
        boolean c1flip = false;
        if (N == 0) return 1;
        while(N>0){
            if(N%2==0){
                if(c1flip){
                    c1flip = false;
                    max = Math.max(count1,max);
                    count1 = 0;
                    count2 ++;
                }
                else{
                    c1flip = true;
                    max = Math.max(count2,max);
                    count1++;
                    count2=0;
                }
            }
            else{
                count1++;
                count2++;
            }
        N = N/2;
        }
        int bigger = Math.max(count1,count2);
        return Math.max(bigger,max);
    }

    public static void main(String[] args) {
        /*System.out.println(insertInt(64,4,4,2));
        System.out.println(BinToStr(0.42041015625));*/
        System.out.println(flipToWin(58));
    }
}
