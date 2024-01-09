/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.



Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
Example 3:

Input: n = 2, pick = 1
Output: 1


Constraints:

1 <= n <= 231 - 1
1 <= pick <= n
 */


/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
public class GuessNumberHigherOrLower_374 {

    public int guessNumber(int n) {

        return guessNumber(0, n);

    }

    public int guessNumber(int start, int end) {

        int n = (start+end)/2;
        int code = guess(n);
        if(code == 0)
            return n;
        if(code < 0)
            return guessNumber(n + 1, end);
        else
            return guessNumber(start, n);

    }

//    public int guessNumber(int n) {
//
//        int n = (start+end)/2;
//      while(true){
//          int res = guess(n);
//          if(guess(n) == 0)
//              return n;
//          if(guess(n) < 0)
//              guessNumber( start, n - 1);
//          else
//              guessNumber(n + 1, end);
//      }
//
//    }

    public int guess(int n){
        if (n==6)
            return 0;
        else if(n < 6)
            return -1;
        else
            return 1;
    }


    public static void main(String[] args){
        GuessNumberHigherOrLower_374 g = new GuessNumberHigherOrLower_374();
        System.out.println(g.guessNumber(10));
    }

}
