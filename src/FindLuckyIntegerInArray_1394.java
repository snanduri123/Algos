import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindLuckyIntegerInArray_1394 {

    //Time : O(n) reading arr + O(n) reading map
    //Space: O(n) map.
    public int findLucky(int[] arr) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        int luckyNum = -1;

        for(Map.Entry<Integer,Integer> pair : map.entrySet()){
            if(pair.getKey() == pair.getValue() && pair.getKey() > luckyNum){
                luckyNum =  pair.getKey();
            }
        }

        return luckyNum;
    }

    public static void main(String[] args){
        FindLuckyIntegerInArray_1394 f = new FindLuckyIntegerInArray_1394();
        System.out.println(f.findLucky(new int[] {2,2,3,4})); //2
        System.out.println(f.findLucky(new int[] {1,2,2,3,3,3})); //3
        System.out.println(f.findLucky(new int[] {2,2,2,3,3})); //-1
    }
}
