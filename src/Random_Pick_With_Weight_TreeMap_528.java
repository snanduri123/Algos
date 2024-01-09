import java.util.Random;
import java.util.TreeMap;

/*
You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.

You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).

For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).


Example 1:

Input
["Solution","pickIndex"]
[[[1]],[]]
Output
[null,0]

Explanation
Solution solution = new Solution([1]);
solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.
Example 2:

Input
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output
[null,1,1,1,1,0]

Explanation
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 0. It is returning the first element (index = 0) that has a probability of 1/4.

Since this is a randomization problem, multiple answers are allowed.
All of the following outputs can be considered correct:
[null,1,1,1,1,0]
[null,1,1,1,1,1]
[null,1,1,1,0,0]
[null,1,1,1,0,1]
[null,1,0,1,0,0]
......
and so on.
 */

//Time: no.of calls * logn   (logn is the search made on TreeMap    )
//Space: O(w.length)
public class Random_Pick_With_Weight_TreeMap_528 {

    int sum = 0;
    TreeMap<Integer,Integer> ceilingToIndex = new TreeMap<>();
    Random r = new Random();

    //Imagine an array of size = sum of all the weights(input).
    // Eg: If w = [1, 4, 5], imaging array of size 1+4+5 = 10 and in that
    //1 part is for 0th index, next 4 parts (2-5) is for 1st index and next 5 parts is for index 3.
    // So Treemap looks like:
    //  key   val
    //  1 -   0  (if random pick is <= 1 then we should return index 0)
    //  5 -   1  (if random pick is 2 to 5 then we should return index 1)
    //  10 -  2  (if random pick is 6 to 10 then we should return index 2)

    public Random_Pick_With_Weight_TreeMap_528(int[] w) {
        for (int i = 0 ; i < w.length ; i++) {
            sum += w[i];
            ceilingToIndex.put(sum, i);
        }
    }

    public int pickIndex() {
        int randomIndex =  r.nextInt(1,sum+1) ;
        return ceilingToIndex.ceilingEntry(randomIndex).getValue() ;
    }

}
