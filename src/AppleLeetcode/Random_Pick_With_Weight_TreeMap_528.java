package AppleLeetcode;

import java.util.Random;
import java.util.TreeMap;

//Time: no.of calls * logn   (logn is the search made on tree map)
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
        return ceilingToIndex.ceilingEntry(randomIndex).getValue(); //least key greater than or equal to the given key, or null if there is no such key.
    }

}
