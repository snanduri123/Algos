public class KnapSack {

    static int maxWeight = 100;

    static int weight[] = {5,20,10, 40, 20, 1};
    static int value[] = {30,100,20, 10, 40, 100};
    static int len = value.length;
    static int[][] mem = new int[maxWeight][value.length];

    public static int findValue(int w, int i){


        System.out.println("w : " + w + " , i : " + i);
        if(w <=0){
            return 0;
        }
        if(i==len)
            return 0;

        if (mem[w][i] != -1) {
            return mem[w][i];
        }

        int opt1 = value[i] + findValue(w-weight[i], i+1);
        int opt2 = 0 + findValue(w,i+1);

        int ans =  opt1 > opt2 ? opt1 : opt2;
        mem[w][i] = ans;
        return ans;
    }

    public static int findMaxValue( int i, int w){
        System.out.println("i : " + i + " , w : " + w);
        if(w <=0){
            return 0;
        }
        if(i==len)
            return 0;

//        if (mem[w][i] != -1) {
//            return mem[w][i];
//        }

        int opt1 = value[i] + findMaxValue( i+1, w-weight[i]);
        int opt2 = 0 + findMaxValue(i+1, w);

        int ans =  opt1 > opt2 ? opt1 : opt2;
        //mem[w][i] = ans;
        return ans;
    }


//  TODO: iterative approach
//  public static int findValue2(){
//        for (int i = 0 ; i < value.length ; i++) {
//            mem[0][i] = 0;
//        }
//        for (int w = 0 ; w <= maxWeight ; w++) {
//            for (int i = value.length - 1 ; i >= 0 ; i++) {
//                int opt1 = value[i] + mem[w - weight[i]][i+1];
//                int opt2 = 0 + mem[w][i+1];
//                int ans =  opt1 > opt2 ? opt1 : opt2;
//                mem[w][i] = ans;
//            }
//        }

//    }

    public static void main(String[] args){

        System.out.println(findValue(100, 0));

        System.out.println(findMaxValue(100, 0));
       // System.out.println(pgm.findMaxForm( strs,  m,  n));
    }
}
