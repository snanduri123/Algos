//
//In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
//
//        For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
//
//        Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
//
//        Note:
//        The given numbers of 0s and 1s will both not exceed 100
//        The size of given string array won't exceed 600.

import java.util.Arrays;

public class Ones_And_Zeroes_KnapSack_474 {

    Integer[][][] cache;


    public static void main(String[] args) {

        Ones_And_Zeroes_KnapSack_474 pgm = new Ones_And_Zeroes_KnapSack_474();

        String[] strs = {"10", "0001", "111001", "1", "0"}; //ans = 4, if m=5 and n=3

        int m = 5;
        int n = 3;

        System.out.println(pgm.findMaxForm(strs, m, n));

        String[] strs2 = {"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"};
        m = 90;
        n = 63;


        System.out.println(pgm.findMaxForm(strs2, m, n));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        cache = new Integer[m + 1][n + 1][strs.length];

        //call the func
        return findMaxForm(m, n, 0, strs);
    }

    public int findMaxForm(int remMCt, int remNCt, int idx, String[] strs) {

//        System.out.println("---------- ");
//        System.out.println("remMCt : " + remMCt);
//        System.out.println("remNCt : " + remMCt);
//        System.out.println("idx : " + idx);

        if (idx >= strs.length) { // if reading all strings is done then there is no string to select
            return 0;
        }

        if (remMCt == 0 && remNCt == 0) { // there are no m's and n's left to identify strings
            return 0;
        }

        if( cache[remMCt][remNCt][idx] != null){
            return  cache[remMCt][remNCt][idx];
        }

        int[] mnCount = find_M_And_N_Count(strs[idx]);
        int mCt = mnCount[0];
        int nCt = mnCount[1];

        int opt1 = 0;
        int opt2 = 0;

        if (remMCt >= mCt && remNCt >= nCt ) {
            opt1 = 1 + findMaxForm(remMCt - mCt, remNCt - nCt, idx + 1, strs);
        }
        opt2 = 0 + findMaxForm(remMCt, remNCt, idx + 1, strs);

        int ans = opt1 > opt2 ? opt1 : opt2;

        cache[remMCt][remNCt][idx] = ans;

        return ans;
    }


    public int[] find_M_And_N_Count(String s) {
        int[] counts = new int[2];
        char[] strArr = s.toCharArray();
        int mct = 0;
        int nct = 0;
        for (int i = 0; i < s.length(); i++) {
            if (strArr[i] == '0') {
                mct++;
            } else {
                nct++;
            }
        }
        counts[0] = mct;
        counts[1] = nct;
        return counts;
    }
}
